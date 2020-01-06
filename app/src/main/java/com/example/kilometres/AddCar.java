package com.example.kilometres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kilometres.model.Car;

import java.text.SimpleDateFormat;

public class AddCar extends AppCompatActivity {


    private Car mCar;
    private EditText mKmAlreadyUsed;
    private EditText mCarName;
    private EditText mKmMax;
    private Button mValidate;
    private Button mCancel;
    private EditText mStartDate;
    private EditText mNumberOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        mCar = new Car();



        mCarName = findViewById(R.id.activity_add_car_carname);
        mKmAlreadyUsed = findViewById(R.id.activity_add_car_current_km);
        mKmMax = findViewById(R.id.activity_add_car_max_km);
        mValidate = findViewById(R.id.activity_add_car_validate);
        mCancel = findViewById(R.id.activity_add_car_cancel);
        mStartDate = findViewById(R.id.activity_add_car_start_date);
        mNumberOfMonth = findViewById(R.id.activity_add_car_number_of_months);


        mValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                SharedPreferences carDB = getSharedPreferences("CarFile", MODE_PRIVATE);
                SharedPreferences.Editor editor = carDB.edit();

               // String startDate = sdf.format(new Date(mStartDate.getDate()));

                mCar.setStartDate(mStartDate.getText().toString());
                mCar.setNumberofMonths(Integer.parseInt(mNumberOfMonth.getText().toString()));
                mCar.setName(mCarName.getText().toString());
                mCar.setMaxKilometers(Integer.parseInt(mKmMax.getText().toString()));
                mCar.setCurrentKilometers(Integer.parseInt(mKmAlreadyUsed.getText().toString()));
                editor.putString("CarName", mCar.getName()).apply();
                editor.putInt("MaxKm",mCar.getMaxKilometers());
                editor.putInt("CurrentKm", mCar.getCurrentKilometers());
                editor.putString("StartDate",mCar.getStartDate());
                editor.putInt("NumberOfMonths", mCar.getNumberofMonths());
                editor.apply();
                Intent mainActivity = new Intent(AddCar.this, MainActivity.class);
                startActivity(mainActivity);



            }
        });


        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(AddCar.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });



    }
}
