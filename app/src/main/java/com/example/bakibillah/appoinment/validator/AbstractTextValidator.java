package com.example.bakibillah.appoinment.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

/**
 * Created by BakiBillah on 9/13/2017.
 */

public abstract class AbstractTextValidator implements TextWatcher {


    private final TextView textView;

    public AbstractTextValidator(TextView textView) {
        this.textView = textView;
    }

    public abstract void validate(TextView textView, String text);

    @Override
    final public void afterTextChanged(Editable s) {
        String text = textView.getText().toString();
        validate(textView, text);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) { }

}
