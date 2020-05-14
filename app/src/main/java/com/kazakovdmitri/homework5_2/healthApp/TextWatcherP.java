package com.kazakovdmitri.homework5_2.healthApp;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


public class TextWatcherP implements TextWatcher {

    public EditText editText;

    public TextWatcherP(EditText et) {
        super();
        editText = et;
    }

    public void afterTextChanged(Editable s) {
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }
}
