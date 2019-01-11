package com.msproject.myhome.mydays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class SettingActivity extends AppCompatActivity {
    LinearLayout title_bar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        title_bar = findViewById(R.id.title_bar);
        recyclerView = findViewById(R.id.setting_recycler_view);
    }
}
