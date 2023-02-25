package com.example.Zapitor.a20.sub.learn;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.Zapitor.a20.R;

/**
 * Created by Zapitor on 24-12-2016.
 */

public class ObliqueStrikeEditText extends EditText {
    private int dividerColor,dividerColor1;
    private Paint paint;
    private Context mContext;

    public ObliqueStrikeEditText(Context context)
    {
        super(context);
        mContext = context;
//        init(context);
    }

    public ObliqueStrikeEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mContext = context;
//        init(context);
    }

    public ObliqueStrikeEditText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mContext = context;
//        init(context);
    }

//    private void init()
//    {
//        Resources resources = mContext.getResources();
//        //replace with your color
//        dividerColor = resources.getColor(R.color.black);
//        paint = new Paint();
//        paint.setColor(dividerColor);
//        //replace with your desired width
//        paint.setStrokeWidth(resources.getDimension(R.dimen.strike));
//    }

    public void setStroke1() {
        Resources resources = mContext.getResources();
        dividerColor = resources.getColor(R.color.title);
        paint = new Paint();
        paint.setColor(dividerColor);
        paint.setStrokeWidth(resources.getDimension(R.dimen.strike));
        invalidate();
    }

    public void setUnStroke1() {
        Resources resources = mContext.getResources();
        dividerColor1 = resources.getColor(R.color.second_grey);
        paint = new Paint();
        paint.setColor(dividerColor1);
        paint.setStrokeWidth(resources.getDimension(R.dimen.Unstrike));
        invalidate();
    }
    public void setUnStroke2() {
        Resources resources = mContext.getResources();
        dividerColor1 = resources.getColor(R.color.white);
        paint = new Paint();
        paint.setColor(dividerColor1);
        paint.setStrokeWidth(resources.getDimension(R.dimen.Unstrike));
        invalidate();
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if(paint != null) {
            canvas.drawLine(0, getHeight(), getWidth(), 0, paint);
        }
    }
}
