package com.example.notepad;

import static android.R.attr.*;

import androidx.appcompat.app.AppCompatActivity;

import android.R.attr;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class font_functions<Textview> extends AppCompatActivity{


    private Spinner spinner;
    private TextView TV_test;




    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.font_functions);


        spinner = (Spinner)findViewById(R.id.spinner);
        TV_test = (TextView)findViewById(R.id.TV_test);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TV_test = (TextView) textColor(TV_test);

            }

            private Object textColor(TextView tv_test) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        }




}
