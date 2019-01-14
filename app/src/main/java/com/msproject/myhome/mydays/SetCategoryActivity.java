package com.msproject.myhome.mydays;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.GridView;
import android.widget.ImageView;

import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;

import java.util.ArrayList;

public class SetCategoryActivity extends AppCompatActivity implements ColorPickerDialogListener {
    ConstraintLayout titleBar;
    GridView gridView;
    FloatingActionButton fab;
    Context context;
    private final int DIALOG_ID = 0;
    UpdateCategoryDialog dialog;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_category);

        if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            getWindow().setStatusBarColor(getColor(R.color.colorTitleBar));
        }
        context = this;
        titleBar = findViewById(R.id.title_bar);
        gridView = findViewById(R.id.category_gridview);
        fab = findViewById(R.id.fab);

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


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new UpdateCategoryDialog(context);
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                dialog.show();
                dialog.setCancelable(true);
                Window window = dialog.getWindow();
                int x = (int)(size.x * 0.8f);
                int y = (int)(size.y * 0.8f);

                window.setLayout(x,y);
            }
        });
    }

    public ArrayList<Category> initCategories(){
        ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category("공부", "#455678"));
        categories.add(new Category("운동", "#fda967"));
        categories.add(new Category("휴식", "#5f5f5f"));

        return categories;
    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (dialogId){
            case DIALOG_ID:
                final int invertColor = ~color;
                final String hexColor = String.format("%X", color);
                final String hexInvertColor = String.format("%X", invertColor);
                if (BuildConfig.DEBUG) {
                    Log.d("color==", "id " + dialogId + " c: " + hexColor + " i:" + hexInvertColor);
                }
                dialog.setPickedColor(hexColor);
                break;
        }

    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }

}
