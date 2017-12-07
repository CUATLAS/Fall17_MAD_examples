package com.example.aileen.gestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;
    private ImageView bb8;
    private ScaleGestureDetector mScaleDetector;

    // The active pointer is the one currently moving our object
    private int mActivePointerId = MotionEvent.INVALID_POINTER_ID;
    // last x coordinate location
    private float lastTouchX;
    // last x coordinate location
    private float lastTouchY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //gesture detector
        mGestureDetector = new GestureDetector(this, new CustomGestureDetector());

        bb8 = (ImageView) findViewById(R.id.bb8);

        //scale detector
        mScaleDetector = new ScaleGestureDetector(this, new CustomScaleListener());

        //touch for drag
        final View.OnTouchListener onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                mGestureDetector.onTouchEvent(event);
                mScaleDetector.onTouchEvent(event);

                //returns action code
                final int action = event.getActionMasked();

                Log.d("Gesture", "onTouch " + action);

                switch (action) {
                    case MotionEvent.ACTION_DOWN: { //0
                        //get pointer index
                        final int pointerIndex = event.getActionIndex();
                        // get location x and y coordinates
                        final float x = event.getRawX();
                        final float y = event.getRawY();

                        lastTouchX = x;
                        lastTouchY = y;

                        mActivePointerId = event.getPointerId(pointerIndex);
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: { //2
                        final float x = event.getRawX();
                        final float y = event.getRawY();

                        //calculate distance moved
                        final float dx = x - lastTouchX;
                        final float dy = y - lastTouchY;

                        //set x and y position
                        v.setX(x - 193);
                        v.setY(y - 400);

                        v.invalidate();

                        lastTouchX = x;
                        lastTouchY = y;

                        break;
                    }
                    case MotionEvent.ACTION_UP: { //1
                        mActivePointerId = MotionEvent.INVALID_POINTER_ID;
                        break;
                    }
                    case MotionEvent.ACTION_CANCEL: {
                        mActivePointerId = MotionEvent.INVALID_POINTER_ID;
                        break;
                    }
                    case MotionEvent.ACTION_POINTER_UP: { //6 handles multiple pointers

                        final int pointerIndex = event.getActionIndex();
                        final int pointerId = event.getPointerId(pointerIndex);

                        if (pointerId == mActivePointerId) {
                            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                            lastTouchX = event.getX(newPointerIndex);
                            lastTouchY = event.getY(newPointerIndex);
                            mActivePointerId = event.getPointerId(newPointerIndex);
                        }
                        break;
                    }
                }
                return true;
            }
        };
        bb8.setOnTouchListener(onTouchListener);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        mGestureDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }

    class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d("Gesture", "on down");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            Log.d("Gesture", "on double tap event");
            Toast toast = Toast.makeText(getApplicationContext(), "I'm BB-8", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }

    class CustomScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        private float scale = 1f;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale = scale * detector.getScaleFactor();
            bb8.setScaleX(scale);
            bb8.setScaleY(scale);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.d("Gesture", "on scale begin");
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            Log.d("Gesture", "on scale end");
            super.onScaleEnd(detector);
        }
    }

//    @Override
//    public boolean onSingleTapConfirmed(MotionEvent e) {
//        Log.d("Gesture", "on single tap");
//        return false;
//    }
//
//    @Override
//    public boolean onDoubleTap(MotionEvent e) {
//        Log.d("Gesture", "on double tap");
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//        Log.d("Gesture", "on show press");
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        Log.d("Gesture", "on single tap up");
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        Log.d("Gesture", "on scroll");
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//        Log.d("Gesture", "on long press");
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        Log.d("Gesture", "on fling");
//        return false;
//    }

}
