package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DragIcon extends AppCompatActivity {
    ImageView iv, ivFrame;
    TextView tv;
    int x, y;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_icon);
        setTitle("DragIcon");

        iv = findViewById(R.id.iv);
        ivFrame = findViewById(R.id.iv_frame);
        tv = findViewById(R.id.tv);

        //觸摸監聽器
        iv.setOnTouchListener(new View.OnTouchListener() {
            int ax, ay, mx, my;

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //以圖片左上角為原點取得點擊座標
                        x = (int) event.getX();
                        y = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //以整個畫面左上角為原點取得點擊座標
                        ax = (int) event.getRawX();
                        ay = (int) event.getRawY();
                        //計算左側座標
                        mx = ax - x;
                        //計算上側座標
                        //由於抓到的座標是全螢幕範圍，但設定的座標只有layout範圍(也就是不包含Status Bar和Action Bar)
                        //所以需減去Status Bar和Action Bar的高度
                        my = ay - y - getBarHeight();

                        //設定圖片的左上右下邊界四個座標
                        view.layout(mx, my, mx + view.getWidth(), my + view.getHeight());

                        //
                        if(((view.getLeft() < ivFrame.getRight() && view.getRight() > ivFrame.getRight()) || (view.getRight() > ivFrame.getLeft() && view.getLeft() < ivFrame.getLeft())) &&
                            ((view.getTop() < ivFrame.getBottom() && view.getBottom() > ivFrame.getBottom()) || (view.getBottom() > ivFrame.getTop() && view.getTop() < ivFrame.getTop()))
                        ){
                            view.layout(ivFrame.getLeft(), ivFrame.getTop(), ivFrame.getRight(), ivFrame.getBottom());
                        }

                        break;
                }

                //需回傳true
                return true;
            }
        });

    }

    //計算畫面上方系統bar高度
    private int getBarHeight() {
        //取得最上方Status Bar高度
        int h1 = getWindow().getDecorView().findViewById(android.R.id.statusBarBackground).getHeight();
        //取得Action Bar高度
        int h2 = getSupportActionBar().getHeight();
        return h1 + h2;
    }
}