package com.kazakovdmitri.homework5_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class ActivityCalendar extends AppCompatActivity {
    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndtDateCalendar;
    private Button mBtnOK;
    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initViews();
    }
    private void initViews() {
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mEndtDateCalendar = findViewById(R.id.endtDateCalendar);
        mBtnOK = findViewById(R.id.btnOK);

        // Скроем календари при запуске приложения
        mStartDateCalendar.setVisibility(View.GONE);
        mEndtDateCalendar.setVisibility(View.GONE);

        mChooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartDateCalendar.setVisibility(View.VISIBLE);
                mEndtDateCalendar.setVisibility(View.GONE);
            }
        });

        mChooseEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEndtDateCalendar.setVisibility(View.VISIBLE);
                mStartDateCalendar.setVisibility(View.GONE);
            }
        });

        mStartDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mStartDateTxt = i2+"."+i1+"."+i;
                mChooseStartDate.setText(getString(R.string.date_start) + mStartDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mStartDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mEndtDateCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                mEndDateTxt = i2+"."+i1+"."+i;
                mChooseEndDate.setText(getString(R.string.date_finish) + mEndDateTxt);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(i, i1, i2);
                mEndDate = gregorianCalendar.getTimeInMillis();
                calendarView.setVisibility(View.GONE);
            }
        });

        mBtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mStartDate > mEndDate){
                    Toast.makeText(ActivityCalendar.this, R.string.error, Toast.LENGTH_LONG).show();
                    mChooseStartDate.setText(getString(R.string.date_start));
                    mChooseEndDate.setText(getString(R.string.date_finish));
                } else {
                    String result = getResources().getString(R.string.result,mStartDateTxt,mEndDateTxt);
                    Toast.makeText(ActivityCalendar.this, result, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
