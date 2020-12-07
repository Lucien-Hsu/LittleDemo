package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lvResult;
    //泛型類別陣列，"?"表示不確定的參數化類型
    Class<?>[] allClass = {RatingBarEx.class,  SeekBarEx.class, DragIcon.class, VideoPlayer.class, GridViewEx.class};

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //取得ListView元件
        lvResult = findViewById(R.id.lv_result);

        //Activity 名稱陣列
        String[] data = {"Rating Bar", "SeekBar", "DragIcon", "VideoPlayer", "GridView"};

        //建立並連接ListView適配器
        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, data);
        lvResult.setAdapter(adapter);

        //ListView監聽
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, RatingBarEx.class);
                switch (i){
                    case 0:
                        intent = new Intent(context, allClass[0]);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, allClass[1]);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, allClass[2]);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, allClass[3]);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context, allClass[4]);
                        startActivity(intent);
                        break;
                }

            }
        });

    }
}