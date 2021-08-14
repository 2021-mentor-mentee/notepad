package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Text extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }

    public void setColorNum(){
//        색깔버튼 색깔 값 가져와서 텍스트뷰에 값 넣기
//        setColor(colorNum);
    }

    public void setColor(String colorNum){
//        텍스트뷰 값을 가져와서 글씨 색깔 바꾸는 역할

    }
}