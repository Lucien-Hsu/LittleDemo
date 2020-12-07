package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PropertyAnimation extends AppCompatActivity {
    int positionX, positionY;

    Button btnUpR, btnDownR, btnUpL, btnDownL;
    Button btnUp, btnDown, btnL, btnR;
    Button btnRun, btnStop;
    ImageView imgChick;

    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        setTitle("PropertyAnimation");

        btnUpR = findViewById(R.id.btn_up_r);
        btnDownR = findViewById(R.id.btn_down_r);
        btnUpL = findViewById(R.id.btn_up_l);
        btnDownL = findViewById(R.id.btn_down_l);

        btnUp = findViewById(R.id.btn_up);
        btnDown = findViewById(R.id.btn_down);
        btnR = findViewById(R.id.btn_r);
        btnL = findViewById(R.id.btn_l);

        btnRun = findViewById(R.id.btn_run);
        btnStop = findViewById(R.id.btn_stop);

        imgChick = findViewById(R.id.img_chick);

        btnUpR.setOnClickListener(new myListener2());
        btnDownR.setOnClickListener(new myListener2());
        btnUpL.setOnClickListener(new myListener2());
        btnDownL.setOnClickListener(new myListener2());

        btnUp.setOnClickListener(new myListener());
        btnDown.setOnClickListener(new myListener());
        btnR.setOnClickListener(new myListener());
        btnL.setOnClickListener(new myListener());

        //播放逐格動畫
        anim = (AnimationDrawable) imgChick.getDrawable();

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                anim.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim.stop();
            }
        });
    }

    /**
     * 屬性動畫，上下左右
     */
    private class myListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_up:
                    positionY -= 100;
                    ObjectAnimator animU = ObjectAnimator.ofFloat(imgChick, "translationY", positionY);
                    animU.setDuration(1000);
                    animU.start();
                    break;
                case R.id.btn_down:
                    positionY += 100;
                    ObjectAnimator animD = ObjectAnimator.ofFloat(imgChick, "translationY", positionY);
                    animD.setDuration(1000);
                    animD.start();
                    break;
                case R.id.btn_r:
                    positionX += 100;
                    ObjectAnimator animR = ObjectAnimator.ofFloat(imgChick, "translationX", positionX);
                    animR.setDuration(1000);
                    animR.start();
                    break;
                case R.id.btn_l:
                    positionX -= 100;
                    ObjectAnimator animL = ObjectAnimator.ofFloat(imgChick, "translationX", positionX);
                    animL.setDuration(1000);
                    animL.start();
                    break;
            }
        }
    }

    /**
     * 屬性動畫，斜上下左右
     */
    private class myListener2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_up_r:
                    positionY -= 100;
                    positionX += 100;
                    move("translationY",positionY, "translationX", positionX);
                    break;
                case R.id.btn_down_r:
                    positionY += 100;
                    positionX += 100;
                    move("translationY",positionY, "translationX", positionX);
                    break;
                case R.id.btn_up_l:
                    positionY -= 100;
                    positionX -= 100;
                    move("translationY",positionY, "translationX", positionX);
                    break;
                case R.id.btn_down_l:
                    positionY += 100;
                    positionX -= 100;
                    move("translationY",positionY, "translationX", positionX);
                    break;
            }
        }

        private void move(String propertyName1,int value1, String propertyName2, int value2) {
            ObjectAnimator animU = ObjectAnimator.ofFloat(imgChick, propertyName1, value1);
            animU.setDuration(1000);

            ObjectAnimator animR = ObjectAnimator.ofFloat(imgChick, propertyName2, value2);
            animR.setDuration(1000);

            AnimatorSet set = new AnimatorSet();
            set.play(animU).with(animR);
            set.start();
        }
    }
}