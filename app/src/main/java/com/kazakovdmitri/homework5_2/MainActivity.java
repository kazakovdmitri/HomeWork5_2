package com.kazakovdmitri.homework5_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kazakovdmitri.homework5_2.healthApp.HealthAppMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Intent intentNotes = new Intent(MainActivity.this, ActivityNotes.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, R.string.msg_settings, Toast.LENGTH_LONG).show();
        }

        if (id == R.id.action_open_health) {
            Intent intentNotes = new Intent(MainActivity.this, HealthAppMainActivity.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_open_chekbox) {
            Intent intentNotes = new Intent(MainActivity.this, ActivityCheckbox.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_open_spinner) {
            Intent intentNotes = new Intent(MainActivity.this, ActivitySpinner.class);
            startActivity(intentNotes);
        }

        if (id == R.id.action_open_calendar) {
            Intent intentNotes = new Intent(MainActivity.this, ActivityCalendar.class);
            startActivity(intentNotes);
        }

        return super.onOptionsItemSelected(item);
    }
}
