package com.example.tpeea.firstapp;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class Slider extends View {
    private float barLength;
    private float barWidth;
    private float cursorDiameter;
    private float minValue=0;
    private float maxValue;
    private Paint mBarPaint =null;
    //private
    private float value;
    private  float currentSlider;
    private float minSlider;
    private float maxSlider;

    public Slider(Context context) {
        super(context);
    }

    public Slider(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    void init(Context context, AttributeSet attrs) {

    }

    public float valueToRatio(float value){
        return (value-minValue)/(maxValue-minValue);
    }

    public float ratioToValue(float ratio){
        return (ratio*(maxValue-minValue))+minValue;
    }
    private Point toPos(float value){
        int x,y;
        x = (int) Math.max(cursorDiameter,barWidth)/2 +getPaddingLeft();
        y = (int) (valueToRatio(value)*barLength+cursorDiameter/2) +getPaddingTop();
        return new Point(x,y);
    }
    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Point p1,p2;
        p1=toPos(minValue);
        p2=toPos(maxValue);
        canvas.drawLine(p1.x,p1.y,p2.x,p2.y,mBarPaint);
    }
}
