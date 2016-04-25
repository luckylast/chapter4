package com.ozwhver.memorygame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by amyhan on 10/03/16.
 */
public class ImageAdapter3 extends BaseAdapter {

    private Context CTX;

    private Integer image_id[] = {
            R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,
            R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,
            R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,
            R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,
            R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,
            R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,R.drawable.cardback3,

    };


    public ImageAdapter3(Context CTX){
        this.CTX = CTX;
    }

    @Override
    public int getCount() {
        return image_id.length;
    }

    @Override
    public Object getItem(int position) {
        return image_id[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        if(convertView == null){
            img = new ImageView(CTX);
            img.setLayoutParams(new GridView.LayoutParams(160,160));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setPadding(8,8,8,8 );
        }else{
            img = (ImageView) convertView;
        }
        img.setImageResource(image_id[position]);
        return img;
    }


}
