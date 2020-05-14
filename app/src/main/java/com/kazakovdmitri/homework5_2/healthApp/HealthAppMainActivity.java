package com.kazakovdmitri.homework5_2.healthApp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kazakovdmitri.homework5_2.R;

public class HealthAppMainActivity extends AppCompatActivity {

    private static final String TAG = "Kazakov";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_main);

        Init();
    }
    protected void Init () {
        Button btnHealth = findViewById(R.id.buttonHealth);
        Button btnPressure = findViewById(R.id.buttonPressure);
        Button btnSave = findViewById(R.id.buttonSave);
        final EditText nameT = findViewById(R.id.editName);
        final EditText ageT = findViewById(R.id.editAge);
        btnHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthAppMainActivity.this, HealthActivity.class);
                startActivity(intent);
                Log.i(TAG, "Нажата кнопка Экрана здоровья");
            }
        });
        btnPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HealthAppMainActivity.this, PressureActivity.class);
                startActivity(intent);
                Log.i(TAG, "Нажата кнопка Экрана давления");
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameT.getText().toString().trim();
                String ageS = ageT.getText().toString().trim();
                if (name.isEmpty()||ageS.isEmpty()) {
                    Toast.makeText(getApplicationContext(), R.string.msg_empty, Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int age = Integer.parseInt(ageS);
                        Patient patient = new Patient(name, age);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), R.string.error_age, Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(getApplicationContext(), R.string.msg_save, Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Нажата кнопка Сохранить");
            }
        });

    }
}
