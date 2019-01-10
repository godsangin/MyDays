package com.msproject.myhome.mydays;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout schedulerView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schedulerView = findViewById(R.id.scheduler_layout);
        schedulerView.setBackground(new ShapeDrawable(new OvalShape()));
        schedulerView.setClipToOutline(true);

        schedulerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float touchX = event.getX();
                float touchY = event.getY();

                int action = event.getAction();

                if (action == MotionEvent.ACTION_OUTSIDE){

                    return false;
                } else if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE){
                    int degree = getDegree(touchX, touchY);
                    int area = getArea(degree);

                    selectMenu(area);

                } else if (action == MotionEvent.ACTION_UP){

                    return false;
                }

                return true;
            }
            private int getDegree(float x, float y){
                int centerX = schedulerView.getWidth() / 2;
                int centerY = schedulerView.getHeight() / 2;

                float calcX = x - centerX;
                float calcY = y - centerY;

                double tan = Math.atan2(calcY, calcX);

                double result = 180 * tan / Math.PI;
                int degree = - ((int) Math.round(result));

                if (degree < 0){
                    degree = 360 + degree;
                }

                return degree;
            }
            private int getArea(int degree){
                if (degree >= 0 && degree < 90){
                    return 1;
                } else if (degree >= 90 && degree < 180){
                    return 2;
                } else if (degree >= 180 && degree < 270){
                    return 3;
                } else if (degree >= 270 && degree < 360){
                    return 4;
                } /*else if (degree >= 240 && degree < 300){
                    return 5;
                } else if (degree >= 300 && degree < 360){
                    return 6;
                }*/ else {
                    return 0;
                }
            }
        });
    }

    private void selectMenu(int areaCode){

        switch(areaCode){

            case 0:
                Log.d("code==", "0");
                break;
            case 1:
                Log.d("code==", "1");
                break;
            case 2:
                Log.d("code==", "2");
                break;
            case 3:
                Log.d("code==", "3");
                break;
            case 4:
                Log.d("code==", "4");
                break;
            case 5:
                Log.d("code==", "5");
                break;
            case 6:
                Log.d("code==", "6");
                break;



        }
    }

}
