package com.example.kilometres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddKilometers extends AppCompatActivity {

    private Button mValidate;
    private Button mCancel;
    private EditText mNewCurrentKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kilometers);
       mValidate = findViewById(R.id.activity_add_kilometers_validate);
        mCancel = findViewById(R.id.activity_add_kilometers_cancel);
        mNewCurrentKm = findViewById(R.id.activity_add_kilometers_add_km);

    mValidate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int newCurrentKm = Integer.parseInt(mNewCurrentKm.getText().toString());
            SharedPreferences carDB = getSharedPreferences("CarFile", MODE_PRIVATE);
            SharedPreferences.Editor editor = carDB.edit();
            editor.putInt("CurrentKm",newCurrentKm);
            editor.apply();
            Intent mainActivity = new Intent(AddKilometers.this, MainActivity.class);
            startActivity(mainActivity);
        }
    });

    mCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent mainActivity = new Intent(AddKilometers.this, MainActivity.class);
            startActivity(mainActivity);

        }
    });

    }

}
