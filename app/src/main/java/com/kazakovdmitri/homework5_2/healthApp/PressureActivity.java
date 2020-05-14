package com.kazakovdmitri.homework5_2.healthApp;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kazakovdmitri.homework5_2.R;

import java.util.ArrayList;
import java.util.Calendar;

public class PressureActivity extends AppCompatActivity {
    private static final String TAG = "Kazakov";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        final ArrayList<Pressure> pressureArray = new ArrayList<>();
        Button btnSave = findViewById(R.id.buttonSave);
        final EditText upPressureT = findViewById(R.id.editUpPressure);
        final EditText downPressureT = findViewById(R.id.editDownPressure);
        final EditText pulseT = findViewById(R.id.editPulse);
        final EditText date = findViewById(R.id.editDate);
        final Switch tachycardia = findViewById(R.id.switchTachycardia);
        TextWatcherP tw = new TextWatcherP(date) {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");
                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    if (clean.equals(cleanC)) sel--;
                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));
                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<2000)?2000:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }
                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));
                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    date.setText(current);
                    date.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        };
        date.addTextChangedListener(tw);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String upPressureS = upPressureT.getText().toString();
                String downPressureS = downPressureT.getText().toString();
                String pulseS = pulseT.getText().toString();
                String dateS = date.getText().toString();
                String tachikardyaS;
                if (tachycardia != null) {
                    tachikardyaS = String.valueOf(R.string.switchYes);
                } else {
                    tachikardyaS = String.valueOf(R.string.switchNo);
                }
                if (upPressureS.isEmpty()||downPressureS.isEmpty()||pulseS.isEmpty()||dateS.isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.msg_empty, Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int upPressure = Integer.parseInt(upPressureS);
                        int downPressure = Integer.parseInt(downPressureS);
                        int pulse = Integer.parseInt(pulseS);
                        String tachikardyaS1 = tachikardyaS;
                        Pressure pressure = new Pressure(upPressure, downPressure, pulse, tachikardyaS1, dateS);
                        pressureArray.add(pressure);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), R.string.msg_error, Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), R.string.msg_save, Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Нажата кнопка Сохранить");
            }
        });
    }
}
