package com.example.bakibillah.appoinment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.example.bakibillah.appoinment.predictor.PeriodPredictionService;

import java.util.Calendar;

/**
 * Created by BakiBillah on 9/13/2017.
 */

public class PeriodRecalculateReceiver extends WakefulBroadcastReceiver {

    public void setPredictionService(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, PeriodRecalculateReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 0);

        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

        ComponentName receiver = new ComponentName(context, AfterBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context, PeriodPredictionService.class);
        service.setAction(PeriodPredictionService.ACTION_SCHEDULED_RECALCULATION);
        startWakefulService(context, service);
    }
}
