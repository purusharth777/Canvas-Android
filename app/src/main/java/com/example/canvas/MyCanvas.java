package com.example.canvas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Icon;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class MyCanvas extends View {
    Paint paint;
    Path path;

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        path=new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7f);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos=event.getX();
        float yPos=event.getY();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:{
                path.moveTo(xPos,yPos);
                return true;
            }
            case MotionEvent.ACTION_MOVE:
            {
                path.lineTo(xPos,yPos);
                return true;
            }
            case MotionEvent.ACTION_UP:
            {
                break;

            }
            default:
                return false;
        }
        invalidate();
        return true;

    }
}
