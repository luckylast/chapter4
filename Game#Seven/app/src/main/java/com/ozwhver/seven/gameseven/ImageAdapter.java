package com.ozwhver.seven.gameseven;

import android.app.ActionBar;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by amyhan on 15/02/16.
 */
public class ImageAdapter extends BaseAdapter {
    public Integer[] mThumbIds = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6, R.drawable.image_7, R.drawable.image_8
    ,R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4, R.drawable.image_5, R.drawable.image_6, R.drawable.image_7, R.drawable.image_8};
    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(LayoutParams.WRAP_CONTENT,200));
        return imageView;
    }
}
