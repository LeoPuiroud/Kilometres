package com.example.kilometres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kilometres.model.Car;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button mAddCar;
    private Button mAddKilometers;
    private TextView mCarName;
    private TextView mCarMaxKm;
    private TextView mCarKmLeft;
    private TextView mTodaysGoal;
    private TextView mTodayReal;
    private Calendar mCalendarToday;
    private TextView mDiffKm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        mTodaysGoal = findViewById(R.id.activity_main_todays_goal);
        mTodayReal = findViewById(R.id.activity_main_real_km);
        mAddCar = findViewById(R.id.activity_main_add_car);
        mAddKilometers = findViewById(R.id.activity_main_add_kilometers);
        mCarName = findViewById(R.id.activity_main_car_name);
        mCarMaxKm =  findViewById(R.id.activity_main_kilometers_max);
        mCarKmLeft = findViewById(R.id.activity_main_kilometers_left);
        mDiffKm = findViewById(R.id.activity_main_km_diff);
        String carName = getSharedPreferences("CarFile",MODE_PRIVATE).getString("CarName","Pas de voiture enregistré");
        int carMaxKm = getSharedPreferences("CarFile",MODE_PRIVATE).getInt("MaxKm",0);
        int carCurrentKm = getSharedPreferences("CarFile", MODE_PRIVATE).getInt("CurrentKm",0);
        int numberOfMonths = getSharedPreferences("CarFile", MODE_PRIVATE).getInt("NumberOfMonths",0);
        String startDate = getSharedPreferences("CarFile", MODE_PRIVATE).getString("StartDate","01/01/2020");
        try {
          Date mDateStart = (sdf.parse(startDate));
          Date today = new Date();
          long diffInMillies = Math.abs(today.getTime() - mDateStart.getTime());
          long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
           if (diffInDays != 0 && numberOfMonths != 0) {
            double kmPredictionForToday = (carMaxKm / (numberOfMonths * 30.416)) * diffInDays;
            double realKmForToday =  carCurrentKm;


            int mKmPredictionForToday = (int) kmPredictionForToday;
            int mRealKmForToday = (int) realKmForToday;
            mTodaysGoal.setText(Integer.toString(mKmPredictionForToday));
            mTodayReal.setText(Integer.toString(mRealKmForToday));
            mDiffKm.setText((Integer.parseInt(mTodaysGoal.getText().toString())-Integer.parseInt(mTodayReal.getText().toString()))+" Km");
            }

            mCarName.setText(carName);
            mCarMaxKm.setText((carMaxKm) + " Km");
            mCarKmLeft.setText((carMaxKm-carCurrentKm) + " Km");

       } catch (ParseException e) {
           e.printStackTrace();
       }




        mAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addCarActivity = new Intent( MainActivity.this, AddCar.class);
                startActivity(addCarActivity);
            }
        });

        mAddKilometers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addKilometersActivity = new Intent(MainActivity.this, AddKilometers.class);
            startActivity(addKilometersActivity);
            }
        });



    }
}
