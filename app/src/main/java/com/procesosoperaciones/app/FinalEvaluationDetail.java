package com.procesosoperaciones.app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class FinalEvaluationDetail extends AppCompatActivity {

    Goal goal;
    LineChart lineChart;
    List<Entry> entriesDone;
    List<Entry> entriesProposed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_evaluation_detail);

        Intent intent = getIntent();
        goal = (Goal) intent.getSerializableExtra("goal");

        lineChart = (LineChart) findViewById(R.id.chart);
        entriesDone = new ArrayList<Entry>();
        entriesProposed = new ArrayList<Entry>();

        for(int i=0; i<goal.getGoalTracing().length; i++)
            entriesDone.add(new Entry((i+1), goal.getGoalTracing()[i]));

        for(int i=0; i<goal.getGoalEvaluated().length; i++)
            entriesProposed.add(new Entry((i+1), goal.getGoalEvaluated()[i]));


        LineDataSet dataSetDone = new LineDataSet(entriesDone, "Hecho");
        dataSetDone.setColor(Color.BLUE);
        dataSetDone.setValueTextColor(Color.BLUE);

        //LineDataSet dataSetProposed = new LineDataSet(entriesProposed, "Propuesto");
        //dataSetDone.setColor(Color.GREEN);
        //dataSetDone.setValueTextColor(Color.GREEN);

        LineData lineData1 = new LineData(dataSetDone);
        //LineData lineData2 = new LineData(dataSetProposed);

        lineChart.setData(lineData1);
        //lineChart.setData(lineData2);

        lineChart.getXAxis().setEnabled(false);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getDescription().setEnabled(false);

        lineChart.invalidate();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //Item selected in menu.
        switch (item.getItemId()){
            case R.id.back:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
