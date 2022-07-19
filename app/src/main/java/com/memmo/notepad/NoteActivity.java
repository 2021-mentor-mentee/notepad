package com.memmo.notepad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.memmo.notepad.Background.mainLinearLayoutColor;
import static com.memmo.notepad.font_functions.mainTextColor;
import static com.memmo.notepad.font_functions.mainTextSize;
import static com.memmo.notepad.font_functions.mainTextStyle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class NoteActivity extends AppCompatActivity {

    EditText et_note;
    Button btn_circle;
    int a = 0;

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        et_note = (EditText) findViewById(R.id.et_note);
        btn_circle = (Button) findViewById(R.id.btn_circle);
        textSetting();// 메모내용 가져와 값 세팅
        backgroundSetting();// 메모색깔 가져와 값 세팅
        onClick();
        preferences = getSharedPreferences("key", MODE_PRIVATE);
        // 저장된 값을 받아오는 함수
        getPreferences();
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
            case 0:
                et_note.setTypeface(null, Typeface.NORMAL);
                break;
            case 1:
                et_note.setTypeface(null, Typeface.ITALIC);
                break;
            case 2:
                et_note.setTypeface(null, Typeface.BOLD);
                break;
        }
    }

    void backgroundSetting() {
        et_note.setBackgroundColor(Color.parseColor(mainLinearLayoutColor));
    }

    void tossText() {// 현재 et_note 의 값을 MainActivity로 넘겨주며 화면전환
        Intent intent = new Intent(NoteActivity.this, MainActivity.class);
        String value = et_note.getText().toString();
        intent.putExtra("textValue", value);
        startActivity(intent); // MainActivity로 화면전환
        finish();// 그와 동시에 현재 화면을 종료
    }

    void onClick() {
        btn_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //전체화면
                View rootView = getWindow().getDecorView();

                File screenShot = ScreenShot(rootView);
                if (screenShot != null) {
                    //갤러리에 추가
                    sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(screenShot)));
                }

                Toast.makeText(getApplicationContext(), "갤러리에 저장되었습니다!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    void SharedPreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        //putString(KEY,VALUE)
        editor.putInt("key", a);
        //항상 commit & apply 를 해주어야 저장이 된다.
        editor.commit();
    }

    private void getPreferences() {
        a = preferences.getInt("key", 0);
    }


    //화면 캡쳐하기
    public File ScreenShot(View view) {
        view.setDrawingCacheEnabled(true);  //화면에 뿌릴때 캐시를 사용하게 한다

        Bitmap screenBitmap = view.getDrawingCache();   //캐시를 비트맵으로 변환

        String filename = a + "screenshot.png";

        File file = new File(Environment.getExternalStorageDirectory() + "/Pictures", filename);  //Pictures폴더 screenshot.png 파일
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            screenBitmap.compress(Bitmap.CompressFormat.PNG, 90, os);   //비트맵을 PNG파일로 변환
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        view.setDrawingCacheEnabled(false);
        a += 1;
        return file;
    }

    @Override
    public void onBackPressed() {
//        뒤로가기 버튼을 눌렀을때 현재 창을 종료하는 기능을 없애고 tossText() 실행
//        super.onBackPressed();
        tossText();
    }

    @Override
    protected void onDestroy() {
        SharedPreferences();
        super.onDestroy();
    }
}

