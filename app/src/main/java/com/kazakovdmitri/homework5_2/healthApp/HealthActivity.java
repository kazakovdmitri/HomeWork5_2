package com.kazakovdmitri.homework5_2.healthApp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kazakovdmitri.homework5_2.R;

import java.util.ArrayList;

public class HealthActivity extends AppCompatActivity {
    private static final String TAG = "Kazakov";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
        final ArrayList<Health> healthArray = new ArrayList<>();
        Button btnSave = findViewById(R.id.buttonSave);
        final EditText weightT = findViewById(R.id.editWeight);
        final EditText stepsT = findViewById(R.id.editSteps);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightS = weightT.getText().toString();
                String stepsS = stepsT.getText().toString();
                if (weightS.isEmpty()||stepsS.isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.msg_empty, Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        double weight = Double.parseDouble(weightS);
                        int steps = Integer.parseInt(stepsS);
                        Health health = new Health(weight, steps);
                        healthArray.add(health);
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
