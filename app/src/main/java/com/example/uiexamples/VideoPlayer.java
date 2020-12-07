package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    Context context;

    private VideoView vv;
    private int position = 0;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        context = this;

        setTitle("VideoPlayer");

        //1.取得videoView元件
        vv = findViewById(R.id.videoView);
        //2-1.建立mediaController，若沒有mediaController則建立一個新的
        if(mediaController == null){
            mediaController = new MediaController(context);
            //2-2.videoView連結mediaController
            vv.setMediaController(mediaController);
        }

        try{
            //3-1.取得資源uri
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.black_hole);
            //3-2.videoView連結uri
            vv.setVideoURI(uri);
        }catch (Exception e){
            e.printStackTrace();
        }

        //4-2.連結監聽器
        vv.setOnPreparedListener(onPreparedListener);
    }

    //4-1.建立監聽器
    OnPreparedListener onPreparedListener = new OnPreparedListener(){
        @Override
        public void onPrepared(MediaPlayer mediaPlayer) {
            //若位置在開頭則播放
            if(position == 0){
                vv.start();
            }

            //將mediaController錨定在videoView中的指定位置
            //若未設定，則會顯示在整個螢幕中的指定位置
            mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                @Override
                public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                    mediaController.setAnchorView(vv);
                }
            });
        }
    };


    //5-1.設置全畫面模式
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //若在播影片則隱藏UI
        if (hasFocus) {
            hideSystemUI();
        }
    }

    //5-2.隱藏UI相關設置
    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        ((View) decorView).setSystemUiVisibility(
                //沉浸模式，設定UI出現後會自動恢復
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        //將系統UI隱藏並變為全螢幕
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}