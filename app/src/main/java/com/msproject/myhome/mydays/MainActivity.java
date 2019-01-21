package com.msproject.myhome.mydays;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView menuButton;
    PieChart pieChart;
    LinearLayout titleBar;


    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuButton = findViewById(R.id.menu_bt);
        titleBar = findViewById(R.id.title_bar);
        TextView textView = titleBar.findViewById(R.id.today);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });

        if (Build.VERSION.SDK_INT >= 21) {
            // 21 버전 이상일 때
            //상단 바 색상 변경
            getWindow().setStatusBarColor(getColor(R.color.colorTitleBar));
        }



        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 클릭시 팝업 메뉴가 나오게 하기
                // PopupMenu 는 API 11 레벨부터 제공한다
                PopupMenu p = new PopupMenu(
                        getApplicationContext(), // 현재 화면의 제어권자
                        v); // anchor : 팝업을 띄울 기준될 위젯
                getMenuInflater().inflate(R.menu.menu_main, p.getMenu());
                // 이벤트 처리
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.statistic_graph) {//StatisicActivity로 intent
                            Intent intent = new Intent(MainActivity.this, StatisticActivity.class);
                            startActivity(intent);
                        } else if (item.getItemId() == R.id.setting) {
                            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                            startActivity(intent);

                        } else if (item.getItemId() == R.id.remove_ad) {//광고제거

                        }
                        return false;
                    }
                });
                p.show(); // 메뉴를 띄우기
            }
        });


        pieChart = (PieChart)findViewById(R.id.piechart);

        //pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setTouchEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));
        yValues.add(new PieEntry(1f,""));

        Description description = new Description();
        description.setText("뭐했니"); //라벨
        description.setTextSize(15);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"?");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(Color.rgb(0,0,0));

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);



    }

}
