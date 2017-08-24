package com.procesosoperaciones.app;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment {

    public ChartFragment() {}

    public static ChartFragment newInstance() {
        ChartFragment fragment = new ChartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_chart, container, false);

        LineChart mChart = (LineChart) container.findViewById(R.id.chart);

        int[] dataObjects = {10, 20, 40};

        List<Entry> entries = new ArrayList<Entry>();

        for (Integer data : dataObjects) {
            // turn your data into Entry objects
            entries.add(new Entry(data, data));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entriesDone to dataset
        dataSet.setColor(Color.BLUE);
        dataSet.setValueTextColor(Color.BLACK); // styling, ...

        LineData lineData = new LineData(dataSet);
        mChart.setData(lineData);
        mChart.getXAxis().setEnabled(false);
        mChart.getAxisLeft().setEnabled(false);
        mChart.getAxisRight().setEnabled(false);
        mChart.invalidate(); // refresh

        return root;
    }

}

