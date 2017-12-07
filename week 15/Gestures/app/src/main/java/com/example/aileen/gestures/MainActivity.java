package com.example.aileen.gestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gesture detector
        mGestureDetector = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d("Gesture", "on single tap");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d("Gesture", "on double tap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d("Gesture", "on double tap event");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d("Gesture", "on down");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.d("Gesture", "on show press");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d("Gesture", "on single tap up");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d("Gesture", "on scroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.d("Gesture", "on long press");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d("Gesture", "on fling");
        return false;
    }
}
