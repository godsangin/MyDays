package com.msproject.myhome.mydays;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    ConstraintLayout titleBar;
    RecyclerView recyclerView;
    Context context;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(getColor(R.color.colorTitleBar));
        }

        titleBar = findViewById(R.id.title_bar);
        recyclerView = findViewById(R.id.setting_recycler_view);
        context = this;

        backButtonEnable();

        ArrayList<SettingItem> mItems = setItems();

        SettingRecyclerAdapter settingRecyclerAdapter = new SettingRecyclerAdapter(mItems, context);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(settingRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void backButtonEnable(){
        ImageView backButton = titleBar.findViewById(R.id.back_bt);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public ArrayList<SettingItem> setItems(){//설정에 필요한게 더 생길 경우 추가
        ArrayList<SettingItem> mItems = new ArrayList<>();

        mItems.add(new SettingItem("테마 설정", "어플리케이션 배경의 색상, 패턴, 디자인 등을 변경할 수 있습니다."));
        mItems.add(new SettingItem("카테고리 설정", "카테고리를 추가 또는 삭제하거나, 카테고리의 색상을 변경할 수 있습니다."));

        return mItems;
    }
}
