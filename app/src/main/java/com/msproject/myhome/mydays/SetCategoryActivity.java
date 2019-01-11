package com.msproject.myhome.mydays;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class SetCategoryActivity extends AppCompatActivity {
    ConstraintLayout titleBar;
    GridView gridView;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_category);

        if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(getColor(R.color.colorTitleBar));
        }

        titleBar = findViewById(R.id.title_bar);
        gridView = findViewById(R.id.category_gridview);

        ImageView backButton = titleBar.findViewById(R.id.back_bt);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<Category> categories = initCategories();
        CategoryGridAdapter gridAdapter = new CategoryGridAdapter(categories);
        gridView.setAdapter(gridAdapter);
    }

    public ArrayList<Category> initCategories(){
        ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category("공부", "#455678"));
        categories.add(new Category("운동", "#fda967"));
        categories.add(new Category("휴식", "#5f5f5f"));

        return categories;
    }
}
