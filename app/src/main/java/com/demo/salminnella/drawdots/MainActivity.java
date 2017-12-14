package com.demo.salminnella.drawdots;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String TAG = "MainActivity";
    ImageView imageView;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint;
    float downx = 0, downy = 0, upx = 0, upy = 0, movex = 0, movey = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.imageView1);

        Display currentDisplay = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        currentDisplay.getSize(size);
        int width = size.x;
        int height = size.y;

        bitmap = Bitmap.createBitmap((int) width, (int) height,
                Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        imageView.setImageBitmap(bitmap);

        imageView.setOnTouchListener(this);

        drawPoints();
    }

    private void drawPoints() {
        canvas.drawCircle(20, 60,15,paint);
        canvas.drawCircle(20, 120,15,paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();

//        float startX = 0;
//        float startY = 0;
//        float endX = 0;
//        float endY = 0;
//
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                startX=event.getX();
//                startY=event.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                endX = event.getX();
//                endY = event.getY();
//                canvas.drawLine(startX,startY,endX,endY, paint);
//                imageView.invalidate();
//                startX=endX;
//                startY=endY;
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//            case MotionEvent.ACTION_CANCEL:
//                break;
//            default:
//                break;
//        }

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d(TAG, "Action Down");
                downx = event.getX();
                downy = event.getY();
                Log.d(TAG, "Down X = " + downx);
                Log.d(TAG, "Down Y = " + downy);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(TAG, "Action Move");
                movex = event.getX();
                movey = event.getY();
                Log.d(TAG, "Move X = " + movex);
                Log.d(TAG, "Move Y = " + movey);
//                canvas.drawCircle(movex, movey,15,paint);
                canvas.drawLine(20,60,movex,movey,paint);
                imageView.invalidate();
                break;
            case MotionEvent.ACTION_UP:
                Log.d(TAG, "Action Up");
//                upx = event.getX();
//                upy = event.getY();
//                canvas.drawLine(downx, downy, upx, upy, paint);
//                imageView.invalidate();


                break;
            case MotionEvent.ACTION_CANCEL:
                Log.d(TAG, "Action Cancel");
                break;
            default:
                break;
        }
        return true;

    }
}
