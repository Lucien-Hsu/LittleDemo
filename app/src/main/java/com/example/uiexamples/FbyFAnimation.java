package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class FbyFAnimation extends AppCompatActivity {
    Context context;
    ImageView imgFrameByFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbyf_animation);
        context = this;

        imgFrameByFrame = findViewById(R.id.img_framebyframe);

        //創建逐格動畫實例
        AnimationDrawable anim2 = (AnimationDrawable) imgFrameByFrame.getDrawable();
        //以逐格動畫實例播放動畫
        anim2.start();
    }
}