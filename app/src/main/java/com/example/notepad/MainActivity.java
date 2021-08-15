package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import static com.example.notepad.font_functions.mainTextColor;


public class MainActivity extends AppCompatActivity {

    private TextView textbox2;
    static EditText Textbox;
    SharedPreferences sp;
    Button Clear, btn_share;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Textbox = findViewById(R.id.Textbox);
        btn_share = (Button)findViewById(R.id.Sharing);
        sp = getSharedPreferences("sp", MODE_PRIVATE);
        String save = sp.getString("save","");
        Textbox.setText(save);
        shareText(); // 공유하기 기능


        

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

    @Override
    protected void onResume() {
        super.onResume();
        Textbox.setTextColor(Color.parseColor(mainTextColor));
    }

    public void shareText() {
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                Sharing_intent.setType("text/plain");

                String Test_Message = Textbox.getText().toString();

                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);

                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                startActivity(Sharing);
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


