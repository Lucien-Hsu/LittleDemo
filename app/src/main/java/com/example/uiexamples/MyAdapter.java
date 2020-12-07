package com.example.uiexamples;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.LinearLayoutCompat;

//實作適配器
class MyAdapter extends BaseAdapter {
//    private final GridViewEx gridViewEx;
    Context context;

    ViewHolder vh;

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
            R.drawable.sakura12,

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

//    public MyAdapter(GridViewEx gridViewEx, Context context) {
    public MyAdapter(Context context) {
//        this.gridViewEx = gridViewEx;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageResId.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    /**
     * ViewHolder
     */
    private static class ViewHolder{
        LinearLayout layout;
        TextView tv;
        ImageView iv;
        CheckBox cb;
        boolean isChecked;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        //若convertView為空則創建一個View
        if(convertView == null){
            //ViewHolder
            vh = new ViewHolder();
            //動態產生LinearLayout
            vh.layout = new LinearLayout(context);
            vh.layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            vh.layout.setOrientation(LinearLayout.VERTICAL);

            //動態產生TestView
            vh.tv = new TextView(context);
            vh.tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            //動態產生ImageView
            vh.iv = new ImageView(context);
            //設定長寬
            vh.iv.setLayoutParams(new LinearLayoutCompat.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 500));

            //CheckBox
            vh.cb = new CheckBox(context);

            //將Layout組裝在一起
            vh.layout.addView(vh.iv);
            vh.layout.addView(vh.tv);
            vh.layout.addView(vh.cb);

            //將新的View給holder
            convertView = vh.layout;

            //設定tag
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        vh.tv.setTextSize(20);
        //調整重心
        vh.tv.setGravity(Gravity.CENTER);

        //設定圖片裁切類型
        vh.iv.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //取得資源名稱
        String title = context.getResources().getResourceName(imageResId[position]);
        //取得去除資料夾名稱後的檔名
        String[] titleStr = title.split("drawable/");
        vh.tv.setText(titleStr[1]);

        //設定圖片
        vh.iv.setImageResource(imageResId[position]);

        //設定CheckBox
        vh.cb.setChecked(vh.isChecked);



        return convertView;
    }
}
