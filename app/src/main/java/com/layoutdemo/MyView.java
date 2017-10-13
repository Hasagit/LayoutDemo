package com.layoutdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by DengJf on 2017/10/13.
 */

public class MyView extends View {
    private int beginX,beginY;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();//获取触摸位置
        int y= (int) event.getY();
        switch (event.getAction()){
            //触摸屏幕
            case MotionEvent.ACTION_DOWN:
                beginX=x;
                beginY=y;
                Log.w("debug","down_x:"+x+"   down_y:"+y);
                break;
            //在屏幕上拖动
            case MotionEvent.ACTION_MOVE:
                //计算拖动距离
                int moveX=x-beginX;
                int moveY=y-beginY;
                layout(getLeft()+moveX,getTop()+moveY,getRight()+moveX,getBottom()+moveY);
                Log.w("debug","move_x"+moveX+"   move_y:"+moveY);
                break;
            //触摸离开屏幕
            case MotionEvent.ACTION_UP:
                Log.w("debug","up_x"+x+"   up_y:"+y);
                break;
        }
        return true;
    }
}
