package com.example.bakibillah.appoinment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by BakiBillah on 9/13/2017.
 */

public class AfterBootReceiver extends BroadcastReceiver {

    PeriodRecalculateReceiver periodRecalculateReceiver = new PeriodRecalculateReceiver();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            periodRecalculateReceiver.setPredictionService(context);
        }
    }
}
