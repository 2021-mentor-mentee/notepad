package com.example.notepad;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;

public class ModDialog extends Activity {

    Button mode_close_bt;
    RadioButton r_btn_light, r_btn_dark;
    String themeColor;

  protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      setContentView(R.layout.activity_mod_dialog);

      r_btn_light = findViewById(R.id.r_btn_light);
      r_btn_dark = findViewById(R.id.r_btn_dark);
      r_btn_light.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              themeColor = ThemeUtil.LIGHT_MODE;
              ThemeUtil.applyTheme(themeColor);
              ThemeUtil.modSave(getApplicationContext(),themeColor);
          }
      });
      r_btn_dark.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              themeColor = ThemeUtil.DARK_MODE;
              ThemeUtil.applyTheme(themeColor);
              ThemeUtil.modSave(getApplicationContext(),themeColor);

          }
      });

      mode_close_bt = findViewById(R.id.mod_change_bt);
      mode_close_bt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              finish();
          }
      });

  }

}
