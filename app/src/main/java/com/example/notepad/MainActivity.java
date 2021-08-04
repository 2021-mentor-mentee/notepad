package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    
    EditText Textbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Textbox = findViewById(R.id.Textbox);

        Button Text = (Button)
                findViewById(R.id.Text);
        Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,font_functions.class);
                startActivity(intent);
            }
        });

        Button name_Text = (Button) findViewById(R.id.Text);
        name_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, font_functions.class);
                startActivity(intent);
            }
        });
    }
}
