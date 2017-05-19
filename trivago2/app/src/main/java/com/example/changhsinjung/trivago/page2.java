package com.example.changhsinjung.trivago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class page2 extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Bundle bundle =this.getIntent().getExtras();
        int money = bundle.getInt("money");
        int people = bundle.getInt("people");
        int day = bundle.getInt("day");
        String chooseway = bundle.getString("chooseway");
        String choosevehicle = bundle.getString("choosevehicle");
        String choosemonth = bundle.getString("choosemonth");
        final EditText result = (EditText) findViewById(R.id.result);

        try {
            InputStream is = getResources().getAssets().open("TRAVEL.csv");
            CBRC Test = new CBRC(is);
            result.setText("HolidayType:"+
                    Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).HolidayType+
                    "\nHotel:"+Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).Hotel+
                    "\nRegion:"+Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).Region+
                    "\nSeason:"+Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).Season+
                    "\nTransportatopn:"+Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).Transportation+
                    "\nPeople:"+Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).NumberOfPersons+
                    "\nPrice:"+Test.DataArr.get(Test.CountCBR(chooseway, money, people, choosevehicle, day, choosemonth).get(0).getKey()).Price
            );
            result.setFocusable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
