package com.example.changhsinjung.trivago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.graphics.Typeface;

public class MainActivity extends AppCompatActivity {
    private TextView intro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button search = (Button)findViewById(R.id.search);
        EditText money = (EditText) findViewById(R.id.money);
        EditText people = (EditText) findViewById(R.id.people);
        EditText day = (EditText) findViewById(R.id.day);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page2.class);
                startActivity(intent);
            }
        });

        Spinner chooseway = (Spinner)findViewById(R.id.chooseway);
        final String[] lunch = {"Bathing", "Active", "Education", "City", "Recreation", "Wandering","Skiing"};
        ArrayAdapter <String> lunchList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, lunch);
        chooseway.setAdapter(lunchList);


        Spinner choosevehicle = (Spinner)findViewById(R.id.choosevehicle);
        final String[] car = {"Plane", "Car", "Train"};
        ArrayAdapter <String> carList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, car);
        choosevehicle.setAdapter(carList);

        Spinner choosemonth = (Spinner)findViewById(R.id.choosemonth);
        final String[] month = {"January","Febuary","March","April","May","June","July","August","Septemper","October","November","December"};
        ArrayAdapter <String> monthList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, month);
        choosemonth.setAdapter(monthList);
    }
}
