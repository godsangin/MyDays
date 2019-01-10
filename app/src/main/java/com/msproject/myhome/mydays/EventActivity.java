package com.msproject.myhome.mydays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        TextView eventTime0 = findViewById(R.id.eventTime0);
        TextView eventTime1 = findViewById(R.id.eventTime1);
        TextView eventTime2 = findViewById(R.id.eventTime2);
        TextView eventTime3 = findViewById(R.id.eventTime3);
        TextView eventTime4 = findViewById(R.id.eventTime4);
        TextView eventTime5 = findViewById(R.id.eventTime5);

        Intent MainIntent = getIntent();
        String date = MainIntent.getStringExtra("date");
        int quarter = MainIntent.getIntExtra("quarter",-1);

        //4분할중 선택된 quarter 구분
        switch (quarter){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;

        }
    }


}
