package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GVDisplay extends AppCompatActivity {
    TextView tv;
    ImageView img;

    private int[] imageResId = {
            R.drawable.sakura01,
            R.drawable.sakura02,
            R.drawable.sakura03,
            R.drawable.sakura04,
            R.drawable.sakura05,
            R.drawable.sakura06,
            R.drawable.sakura07,
            R.drawable.sakura08,
            R.drawable.sakura09,
            R.drawable.sakura10,
            R.drawable.sakura11,
            R.drawable.sakura12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_v_display);

        setTitle("GVDisplay");

        Intent intent = getIntent();
        int id = intent.getIntExtra("detail", 0);

        tv = findViewById(R.id.tv_display);


        //取得去除資料夾名稱後的檔名
        String title = getResources().getResourceName(imageResId[id]);
        String[] titleStr = String.valueOf(title).split("drawable/");
        //設定文字
        tv.setText(titleStr[1]);

        //設定圖片
        img = findViewById(R.id.img_display);
        img.setImageResource(imageResId[id]);

    }
}