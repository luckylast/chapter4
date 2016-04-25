package com.example.amyhan.myfifthapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by amyhan on 4/02/16.
 */
public class AndroidATCView extends View {
    //circle and text color
    private int squareCol, labelCol;
    //label text
    private String squareText;
    //paint for drawing custom view
    private Paint squarePaint;


    public AndroidATCView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //paint object for drawing in onDraw
        squarePaint = new Paint();
        //get the attributes specified in attrs.xml
        //using the name you included
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.AndroidATCView, 0, 0);

        try{
            //get the text and colors specified using
            //the names in attrs.xml
            squareText = a.getString(R.styleable.AndroidATCView_squareLabel);
            squareCol = a.getInteger(R.styleable.AndroidATCView_squareColor, 0); // 0 is default
            labelCol = a.getInteger(R.styleable.AndroidATCView_LabelColor, 0)
        }finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //set drawing properties
        squarePaint.setStyle(Paint.Style.FILL);
        squarePaint.setAntiAlias(true);

        //set the paint color using the circle color specified
        squarePaint.setColor(squareCol);

        //draw the Square using the properties defined
        canvas.drawRect(0,0,this.getMeasuredWidth(), this.getMeasuredHeight(), squarePaint);

        //set the text color using the color spcified
        squarePaint.setColor(labelCol);

        //set text properties
        squarePaint.setTextAlign(Paint.Align.CENTER);
        squarePaint.setTextSize(50);

        //draw the text using the string attribute and chosed properties
        canvas.drawText(squareText, this.getMeasuredWidth()/2, this.getMeasuredHeight()/2, squarePaint);

    }
}
