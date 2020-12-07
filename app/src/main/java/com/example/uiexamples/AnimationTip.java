package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationTip extends AppCompatActivity {
    Context context;
    TextView tvClick, tvTip1, tvTip2, tvTip3;
    ImageView imgBulb;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_tip);
        setTitle("AnimationTip");
        context = this;

        //取得元件
        tvClick = findViewById(R.id.tv_click);
        imgBulb = findViewById(R.id.img_bulb);
        tvTip1 = findViewById(R.id.tv_tip1);
        tvTip2 = findViewById(R.id.tv_tip2);
        tvTip3 = findViewById(R.id.tv_tip3);

        imgBulb.setVisibility(View.VISIBLE);
        tvClick.setVisibility(View.VISIBLE);
        tvTip1.setVisibility(View.VISIBLE);
        tvTip2.setVisibility(View.INVISIBLE);
        tvTip3.setVisibility(View.INVISIBLE);

        tvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;

                if(count == 1){
                    tvTip1.setVisibility(View.INVISIBLE);
                    tvTip2.setVisibility(View.VISIBLE);
                    tvTip3.setVisibility(View.INVISIBLE);
                }else if(count == 2){
                    tvTip1.setVisibility(View.INVISIBLE);
                    tvTip2.setVisibility(View.INVISIBLE);
                    tvTip3.setVisibility(View.VISIBLE);
                }else if(count == 3){
                    tvTip1.setVisibility(View.GONE);
                    tvTip2.setVisibility(View.GONE);
                    tvTip3.setVisibility(View.GONE);
                    tvClick.setVisibility(View.GONE);
                    //清除動畫
                    imgBulb.clearAnimation();
                    imgBulb.setVisibility(View.GONE);
                }
            }
        });

        //創建動畫實例
        Animation anim = AnimationUtils.loadAnimation(context, R.anim.anim);
        //以圖片執行動畫
        imgBulb.startAnimation(anim);

    }
}