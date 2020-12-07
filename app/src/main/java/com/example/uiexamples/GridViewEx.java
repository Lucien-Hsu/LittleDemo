package com.example.uiexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridViewEx extends AppCompatActivity {
    Context context;

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
        setContentView(R.layout.activity_grid_view);
        context = this;

        setTitle("GridView");

        GridView gridView = findViewById(R.id.gridview);
        MyAdapter adapter = new MyAdapter(this);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, GVDisplay.class);
                intent.putExtra("detail", i);
                startActivity(intent);
            }
        });

    }

}