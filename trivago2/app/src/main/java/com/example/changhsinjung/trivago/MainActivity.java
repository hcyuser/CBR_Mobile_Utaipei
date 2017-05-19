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
        final Button search = (Button)findViewById(R.id.search);
        final EditText money = (EditText) findViewById(R.id.money);
        final EditText people = (EditText) findViewById(R.id.people);
        final EditText day = (EditText) findViewById(R.id.day);


       final  Spinner chooseway = (Spinner)findViewById(R.id.chooseway);
        final String[] lunch = {"Bathing", "Active", "Education", "City", "Recreation", "Wandering","Skiing"};
        ArrayAdapter <String> lunchList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, lunch);
        chooseway.setAdapter(lunchList);


        final Spinner choosevehicle = (Spinner)findViewById(R.id.choosevehicle);
        final String[] car = {"Plane", "Car", "Train"};
        ArrayAdapter <String> carList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, car);
        choosevehicle.setAdapter(carList);

        final Spinner choosemonth = (Spinner)findViewById(R.id.choosemonth);
        final String[] month = {"January","Febuary","March","April","May","June","July","August","Septemper","October","November","December"};
        ArrayAdapter <String> monthList = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, month);
        choosemonth.setAdapter(monthList);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , page2.class);
                Bundle bundle = new Bundle();
                bundle.putInt("money",Integer.valueOf(money.getText().toString()));
                bundle.putInt("people",Integer.valueOf(people.getText().toString()));
                bundle.putInt("day",Integer.valueOf(day.getText().toString()));
                bundle.putString("chooseway",chooseway.getSelectedItem().toString());
                bundle.putString("choosevehicle",choosevehicle.getSelectedItem().toString());
                bundle.putString("choosemonth",choosemonth.getSelectedItem().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
