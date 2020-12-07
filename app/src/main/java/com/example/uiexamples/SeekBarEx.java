package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarEx extends AppCompatActivity {
    SeekBar sbA, sbR, sbG, sbB;
    ConstraintLayout layoutSK;
    TextView tvShowColor;
    //設定預設顏色
    int a = 128;
    int r = 128;
    int g = 128;
    int b = 128;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_ex);
        //設定標題
        setTitle("SeekBarEx");

        //取得view
        sbA = findViewById(R.id.seekBar_a);
        sbR = findViewById(R.id.seekBar_r);
        sbG = findViewById(R.id.seekBar_g);
        sbB = findViewById(R.id.seekBar_b);
        layoutSK = findViewById(R.id.layout_sk);
        tvShowColor = findViewById(R.id.tv_show_color);

        //連結SeekBar監聽器
        sbA.setOnSeekBarChangeListener(listener);
        sbR.setOnSeekBarChangeListener(listener);
        sbG.setOnSeekBarChangeListener(listener);
        sbB.setOnSeekBarChangeListener(listener);

        //先印出預設顏色字串
        tvShowColor.setText("a:" + a + " R:" + r + " G:" + g + " B:" + b);
    }

    //設定SeekBar監聽器
    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {

        //進度發生改變時會觸發
        //引數一是SeekBar，引數二是SeekBar的位置，引數三若是使用者移動SeekBar則為true
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean boo) {
            //依據ID判斷是哪一個SeekBar被更動，做出對應的動作
            switch (seekBar.getId()){
                case R.id.seekBar_a:
                    a = progress;
                    break;
                case R.id.seekBar_r:
                    r = progress;
                    break;
                case R.id.seekBar_g:
                    g = progress;
                    break;
                case R.id.seekBar_b:
                    b = progress;
                    break;
            }
            //印出顏色字串
            layoutSK.setBackgroundColor(Color.argb(a,r,g,b));
            //更改背景顏色
            tvShowColor.setText("a:" + a + " R:" + r + " G:" + g + " B:" + b);
        }

        //按住SeekBar時會觸發
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(SeekBarEx.this, "按下SeekBar", Toast.LENGTH_SHORT).show();
        }
        //放開SeekBar時會觸發
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(SeekBarEx.this, "放開SeekBar", Toast.LENGTH_SHORT).show();
        }
    };
}