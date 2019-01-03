package com.msproject.myhome.mydays;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatisticActivity extends AppCompatActivity {

    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);

        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);
        ///
        pieChart.setTouchEnabled(false);
        ///

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

//        yValues.add(new PieEntry(34f,"Japen"));
//        yValues.add(new PieEntry(23f,"USA"));
//        yValues.add(new PieEntry(14f,"UK"));
//        yValues.add(new PieEntry(35f,"India"));
//        yValues.add(new PieEntry(40f,"Russia"));
//        yValues.add(new PieEntry(40f,"Korea"));

        yValues.add(new PieEntry(1f,"1"));
        yValues.add(new PieEntry(1f,"2"));
        yValues.add(new PieEntry(1f,"3"));
        yValues.add(new PieEntry(1f,"4"));
        yValues.add(new PieEntry(1f,"5"));
        yValues.add(new PieEntry(1f,"6"));
        yValues.add(new PieEntry(1f,"7"));
        yValues.add(new PieEntry(1f,"8"));
        yValues.add(new PieEntry(1f,"9"));
        yValues.add(new PieEntry(1f,"10"));
        yValues.add(new PieEntry(1f,"11"));
        yValues.add(new PieEntry(1f,"12"));
        yValues.add(new PieEntry(1f,"13"));
        yValues.add(new PieEntry(1f,"14"));
        yValues.add(new PieEntry(1f,"15"));
        yValues.add(new PieEntry(1f,"16"));
        yValues.add(new PieEntry(1f,"17"));
        yValues.add(new PieEntry(1f,"18"));
        yValues.add(new PieEntry(1f,"19"));
        yValues.add(new PieEntry(1f,"20"));
        yValues.add(new PieEntry(1f,"21"));
        yValues.add(new PieEntry(1f,"22"));
        yValues.add(new PieEntry(1f,"23"));
        yValues.add(new PieEntry(1f,"24"));


//        Description description = new Description();
//        description.setText("세계 국가"); //라벨
//        description.setTextSize(15);
//        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic); //애니메이션
        PieDataSet dataSet = new PieDataSet(yValues,"Countries");
        dataSet.setSliceSpace(0.1f); // 간격
        dataSet.setSelectionShift(5f);

        ///
        int[] myColor = {Color.rgb(0xAA,0xAA,0xAA)};
        //데이터 컬러 설정
        dataSet.setColors(myColor);
        ///
//        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);

        pieChart.setData(data);
    }
}
