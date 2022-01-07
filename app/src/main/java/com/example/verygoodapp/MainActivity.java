package com.example.verygoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("BMW E39");
        arrayList.add("Audi TT");
        arrayList.add("Hyundai i30");
        arrayList.add("Bentley Continental GT");
        arrayList.add("Porsche 911 Turbo S");
        arrayList.add("Polski Fiat 126");
        arrayList.add("Mercedes 190");
        arrayList.add("Audi RS3");
        arrayList.add("Ford Mustang");
        arrayList.add("Tata Nano");
        arrayList.add("Papa Mobile");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                String temp = "ListElement" + i;

                try {
                    Class classElement = Class.forName("com.example.verygoodapp." + temp);
                    Intent intent = new Intent(getApplicationContext(), classElement);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}