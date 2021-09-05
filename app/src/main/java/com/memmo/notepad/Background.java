package com.memmo.notepad;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Background extends AppCompatActivity {

    static String mainLinearLayoutColor = "white";
    Button btn_revert, btn_save;
    LinearLayout background_layout;
    Button btn_color[] = new Button[50];
    String color[] = new String[50];
    String temporaryColor, nowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_screen);
        defaultColorSetting();
        background_layout = (LinearLayout)findViewById(R.id.background_layout);
        btn_revert = (Button)findViewById(R.id.Revert);
        btn_save = (Button)findViewById(R.id.Save);
        LinearLayoutColorChange();               // 색깔 버튼을 눌렀을떄 예시 색 적용
        saveLinearLayoutOption();              // 지금상태를 저장
        LinearLayoutBackgroudColorRevert();  // 원래 색으로 되돌리기

    }


    void LinearLayoutColorChange() {  // 색깔 버튼을 눌렀을떄 예시 색 적용
        for (int i = 0; i < 50; i++) {
            int a = i;
            btn_color[a].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    background_layout.setBackgroundColor(Color.parseColor(color[a]));
                    nowColor = color[a];
                }
            });
        }
    }

    public void saveLinearLayoutOption(){  // 지금색을 저장
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainLinearLayoutColor  = nowColor;
            }
        });
    }

    void LinearLayoutBackgroudColorRevert() {  // 원래 색으로 되돌리기
        btn_revert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainLinearLayoutColor = temporaryColor;
                background_layout.setBackgroundColor(Color.parseColor(mainLinearLayoutColor));
            }
        });
    }


    void defaultColorSetting() {  // 변수에 색깔 세팅
        btn_color[0] = (Button)findViewById(R.id.Color1); btn_color[1] = (Button)findViewById(R.id.Color2); btn_color[2] = (Button)findViewById(R.id.Color3);
        btn_color[3] = (Button)findViewById(R.id.Color4); btn_color[4] = (Button)findViewById(R.id.Color5); btn_color[5] = (Button)findViewById(R.id.Color6);
        btn_color[6] = (Button)findViewById(R.id.Color7); btn_color[7] = (Button)findViewById(R.id.Color8); btn_color[8] = (Button)findViewById(R.id.Color9);
        btn_color[9] = (Button)findViewById(R.id.Color10);

        btn_color[10] = (Button)findViewById(R.id.Color11); btn_color[11] = (Button)findViewById(R.id.Color12); btn_color[12] = (Button)findViewById(R.id.Color13);
        btn_color[13] = (Button)findViewById(R.id.Color14); btn_color[14] = (Button)findViewById(R.id.Color15); btn_color[15] = (Button)findViewById(R.id.Color16);
        btn_color[16] = (Button)findViewById(R.id.Color17); btn_color[17] = (Button)findViewById(R.id.Color18); btn_color[18] = (Button)findViewById(R.id.Color19);
        btn_color[19] = (Button)findViewById(R.id.Color20);

        btn_color[20] = (Button)findViewById(R.id.Color21); btn_color[21] = (Button)findViewById(R.id.Color22); btn_color[22] = (Button)findViewById(R.id.Color23);
        btn_color[23] = (Button)findViewById(R.id.Color24); btn_color[24] = (Button)findViewById(R.id.Color25); btn_color[25] = (Button)findViewById(R.id.Color26);
        btn_color[26] = (Button)findViewById(R.id.Color27); btn_color[27] = (Button)findViewById(R.id.Color28); btn_color[28] = (Button)findViewById(R.id.Color29);
        btn_color[29] = (Button)findViewById(R.id.Color30);

        btn_color[30] = (Button)findViewById(R.id.Color31); btn_color[31] = (Button)findViewById(R.id.Color32); btn_color[32] = (Button)findViewById(R.id.Color33);
        btn_color[33] = (Button)findViewById(R.id.Color34); btn_color[34] = (Button)findViewById(R.id.Color35); btn_color[35] = (Button)findViewById(R.id.Color36);
        btn_color[36] = (Button)findViewById(R.id.Color37); btn_color[37] = (Button)findViewById(R.id.Color38); btn_color[38] = (Button)findViewById(R.id.Color39);
        btn_color[39] = (Button)findViewById(R.id.Color40);

        btn_color[40] = (Button)findViewById(R.id.Color41); btn_color[41] = (Button)findViewById(R.id.Color42); btn_color[42] = (Button)findViewById(R.id.Color43);
        btn_color[43] = (Button)findViewById(R.id.Color44); btn_color[44] = (Button)findViewById(R.id.Color45); btn_color[45] = (Button)findViewById(R.id.Color46);
        btn_color[46] = (Button)findViewById(R.id.Color47); btn_color[47] = (Button)findViewById(R.id.Color48); btn_color[48] = (Button)findViewById(R.id.Color49);
        btn_color[49] = (Button)findViewById(R.id.Color50);

        color[0] = "#FFD8D8"; color[1] = "#FAECC5"; color[2] = "#FAF4C0"; color[3] = "#E4F7BA"; color[4] = "#CEFBC9"; color[5] = "#D4F4FA"; color[6] = "#D9E5FF";
        color[7] = "#E8D9FF"; color[8] = "#FFD9FA"; color[9] = "#FFFFFF";
        color[10] = "#FFA7A7"; color[11] = "#FFE08C"; color[12] = "#FAED7D"; color[13] = "#CEF279"; color[14] = "#B7F0B1"; color[15] = "#B2EBF4"; color[16] = "#B2CCFF";
        color[17] = "#D1B2FF"; color[18] = "#FFB2F5"; color[19] = "#EAEAEA";
        color[20] = "#FF0000"; color[21] = "#FFBB00"; color[22] = "#FFE400"; color[23] = "#ABF200"; color[24] = "#1DDB16"; color[25] = "#00D8FF"; color[26] = "#0054FF";
        color[27] = "#5F00FF"; color[28] = "#FF00DD"; color[29] = "#BDBDBD";
        color[30] = "#980000"; color[31] = "#997000"; color[32] = "#998A00"; color[33] = "#6B9900"; color[34] = "#2F9D27"; color[35] = "#008299"; color[36] = "#003399";
        color[37] = "#3F0099"; color[38] = "#990085"; color[39] = "#5D5D5D";
        color[40] = "#670000"; color[41] = "#664B00"; color[42] = "#664B00"; color[43] = "#476600"; color[44] = "#22741C"; color[45] = "#005766"; color[46] = "#002266";
        color[47] = "#2A0066"; color[48] = "#990085"; color[49] = "#191919";

        temporaryColor = mainLinearLayoutColor;
    }
}
