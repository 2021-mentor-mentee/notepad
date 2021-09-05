package com.memmo.notepad;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.memmo.notepad.font_functions.mainTextColor;
import static com.memmo.notepad.font_functions.mainTextSize;
import static com.memmo.notepad.font_functions.mainTextStyle;

public class NoteActivity extends AppCompatActivity {

    EditText et_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        et_note = (EditText)findViewById(R.id.et_note);
        textSetting(); // 메모내용 가져와 값 세팅
    }

    void textSetting() {
        // 글 내용 적용
        Intent intent = getIntent();
        String value = intent.getStringExtra("textValue");
        et_note.setText(value);
        // 글씨 속성 적용
        et_note.setTextColor(Color.parseColor(mainTextColor));
        et_note.setTextSize(mainTextSize);
        switch (mainTextStyle) {
            case 0: et_note.setTypeface(null, Typeface.NORMAL);break;
            case 1: et_note.setTypeface(null, Typeface.ITALIC);break;
            case 2: et_note.setTypeface(null, Typeface.BOLD);break;
        }
    }

    void tossText() {// 현재 et_note 의 값을 MainActivity로 넘겨주며 화면전환
        Intent intent = new Intent(NoteActivity.this, MainActivity.class);
        String value = et_note.getText().toString();
        intent.putExtra("textValue", value);
        startActivity(intent); // MainActivity로 화면전환
        finish();// 그와 동시에 현재 화면을 종료
    }

    @Override
    public void onBackPressed() {
//        뒤로가기 버튼을 눌렀을때 현재 창을 종료하는 기능을 없애고 tossText() 실행
//        super.onBackPressed();
        tossText();
    }
}

