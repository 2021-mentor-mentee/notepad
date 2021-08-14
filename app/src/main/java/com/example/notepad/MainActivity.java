package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textbox2;
    EditText Textbox;
    SharedPreferences sp;
    Button Clear;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        font_functions ff = new font_functions(); // font_functions 객체화
        Textbox = findViewById(R.id.Textbox);
        sp = getSharedPreferences("sp", MODE_PRIVATE);
        String save = sp.getString("save","");
        Textbox.setText(save);
        Textbox.setTextColor(Integer.parseInt(ff.mainTextColor)); // 글씨색 적용

        

        //배경 버튼 화면 넘기기 기능 넣기
        Button background_bt = (Button)
        findViewById(R.id.background_bt);
        background_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Background.class);
                startActivity(intent);
            }
        });

        Button name_background_bt = (Button) findViewById(R.id.background_bt);
        name_background_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Background.class);
                startActivity(intent);
            }
        });



        //글씨 버튼 화면 넘기기 기능 넣기
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



    //텍스트 값 저장 기능
    protected void onDestroy(){
        super.onDestroy();
        save(Textbox.getText().toString());
    }
    public void save(String s){
        sp = getSharedPreferences("sp",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("save",s);
        editor.commit();
    }
}


