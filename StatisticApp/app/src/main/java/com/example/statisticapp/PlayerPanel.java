package com.example.statisticapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class PlayerPanel extends AppCompatActivity {

    private Button mBack;
    private TextView mName, mSurname;
    private BarChart barChart1;
    private BarChart barChart2;
    private BarChart barChart3;
    private BarChart barChart4;
    private RadarChart radarChart;
    private ArrayList<BarEntry> BararrayList1 = new ArrayList<>();
    private ArrayList<BarEntry> BararrayList2 = new ArrayList<>();
    private ArrayList<BarEntry> BararrayList3 = new ArrayList<>();
    private ArrayList<BarEntry> BararrayList4 = new ArrayList<>();
    private ArrayList<RadarEntry> RadararrayList1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_panel);

        mBack = findViewById(R.id.backplayer);
        mName = findViewById(R.id.NAME);
        mSurname = findViewById(R.id.SURNAME);
        barChart1 = findViewById(R.id.barChart1);
        barChart2 = findViewById(R.id.barChart2);
        barChart3 = findViewById(R.id.barChart3);
        barChart4 = findViewById(R.id.barChart4);
        radarChart = findViewById(R.id.radarChart);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlayerPanel.this,PlayersList.class));
                finish();
            }
        });

        DatabaseHelper db = new DatabaseHelper( PlayerPanel.this);
        Bundle extras = getIntent().getExtras();
        int player_id = extras.getInt("id");
        Player_Simple player = db.getPlayer(player_id);
        mName.setText(player.getNAME());
        mSurname.setText(player.getSURNAME());

        Random random = new Random();

        //Points per game
        BararrayList1.clear();
        BararrayList1.add(new BarEntry(Float.parseFloat("1"), (float) random.nextInt(30-1)+1));
        BararrayList1.add(new BarEntry(Float.parseFloat("2"), (float) random.nextInt(30-1)+1));
        BararrayList1.add(new BarEntry(Float.parseFloat("3"), (float) random.nextInt(30-1)+1));
        BararrayList1.add(new BarEntry(Float.parseFloat("4"), (float) random.nextInt(30-1)+1));
        BararrayList1.add(new BarEntry(Float.parseFloat("5"), (float) random.nextInt(30-1)+1));

        BarDataSet barDataSet = new BarDataSet(BararrayList1,"");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart1.setFitBars(true);
        barChart1.setData(barData);
        barChart1.disableScroll();
        // -------------------------------------------------

        // Rebounds per game
        BararrayList2.clear();
        BararrayList2.add(new BarEntry(Float.parseFloat("1"), (float) random.nextInt(14-1)+1));
        BararrayList2.add(new BarEntry(Float.parseFloat("2"), (float) random.nextInt(14-1)+1));
        BararrayList2.add(new BarEntry(Float.parseFloat("3"), (float) random.nextInt(14-1)+1));
        BararrayList2.add(new BarEntry(Float.parseFloat("4"), (float) random.nextInt(14-1)+1));
        BararrayList2.add(new BarEntry(Float.parseFloat("5"), (float) random.nextInt(14-1)+1));

        BarDataSet barDataSet2 = new BarDataSet(BararrayList2,"");
        barDataSet2.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet2.setValueTextColor(Color.BLACK);
        barDataSet2.setValueTextSize(16f);

        BarData barData2 = new BarData(barDataSet2);

        barChart2.setFitBars(true);
        barChart2.setData(barData2);
        barChart2.disableScroll();

        // Assits per game
        BararrayList3.clear();
        BararrayList3.add(new BarEntry(Float.parseFloat("1"), (float) random.nextInt(10-1)+1));
        BararrayList3.add(new BarEntry(Float.parseFloat("2"), (float) random.nextInt(10-1)+1));
        BararrayList3.add(new BarEntry(Float.parseFloat("3"), (float) random.nextInt(10-1)+1));
        BararrayList3.add(new BarEntry(Float.parseFloat("4"), (float) random.nextInt(10-1)+1));
        BararrayList3.add(new BarEntry(Float.parseFloat("5"), (float) random.nextInt(10-1)+1));

        BarDataSet barDataSet3 = new BarDataSet(BararrayList3,"");
        barDataSet3.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet3.setValueTextColor(Color.BLACK);
        barDataSet3.setValueTextSize(16f);

        BarData barData3 = new BarData(barDataSet3);

        barChart3.setFitBars(true);
        barChart3.setData(barData3);
        barChart3.disableScroll();

        // Steals per game
        BararrayList4.clear();
        BararrayList4.add(new BarEntry(Float.parseFloat("1"), (float) random.nextInt(8-1)+1));
        BararrayList4.add(new BarEntry(Float.parseFloat("2"), (float) random.nextInt(8-1)+1));
        BararrayList4.add(new BarEntry(Float.parseFloat("3"), (float) random.nextInt(8-1)+1));
        BararrayList4.add(new BarEntry(Float.parseFloat("4"), (float) random.nextInt(8-1)+1));
        BararrayList4.add(new BarEntry(Float.parseFloat("5"), (float) random.nextInt(8-1)+1));

        BarDataSet barDataSet4 = new BarDataSet(BararrayList4,"");
        barDataSet4.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet4.setValueTextColor(Color.BLACK);
        barDataSet4.setValueTextSize(16f);

        BarData barData4 = new BarData(barDataSet4);

        barChart4.setFitBars(true);
        barChart4.setData(barData4);
        barChart4.disableScroll();

        RadararrayList1.clear();
        RadararrayList1.add(new RadarEntry(random.nextInt(98-10)+1));
        RadararrayList1.add(new RadarEntry(random.nextInt(98-10)+1));
        RadararrayList1.add(new RadarEntry(random.nextInt(98-10)+1));
        RadararrayList1.add(new RadarEntry(random.nextInt(98-10)+1));
        RadararrayList1.add(new RadarEntry(random.nextInt(98-10)+1));


        RadarDataSet radarDataSet = new RadarDataSet(RadararrayList1,"%");
        radarDataSet.setColor(Color.RED);
        radarDataSet.setLineWidth(2f);
        radarDataSet.setValueTextColor(Color.RED);
        radarDataSet.setValueTextSize(16f);

        RadarData radarData = new RadarData();
        radarData.addDataSet(radarDataSet);

        String[] label = {"Fatigue","Speed","Jumping","Musculature","Satisfaction"};

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(label));
        radarChart.setData(radarData);



    }
}