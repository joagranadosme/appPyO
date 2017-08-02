package com.procesosoperaciones.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;

public class TracingFragment extends Fragment {


    private int period;
    private Goal current;
    private Calendar calendar;
    private ListView tracingList;
    private TracingAdapter tracingAdapter;

    private static final int TRACING = 1;

    public TracingFragment() {}

    public static TracingFragment newInstance(){
        TracingFragment fragment = new TracingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.tracing_fragment, container, false);

        calendar = Calendar.getInstance();

        tracingList = (ListView) root.findViewById(R.id.tracing_list);
        tracingAdapter = new TracingAdapter(getActivity(), GoalRepository.getInstance(getContext()).getGoals());
        tracingList.setAdapter(tracingAdapter);
        tracingList.setLongClickable(true);

        tracingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                current = tracingAdapter.getItem(position);
                period = getPeriod(current.getGoalTracing().length, calendar.get(Calendar.MONTH));
                Intent intent = new Intent(getActivity(), TracingDetailActivity.class);
                intent.putExtra("goal", current);
                intent.putExtra("period", period);
                startActivityForResult(intent, TRACING);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TRACING && resultCode == Activity.RESULT_OK){
                tracingAdapter.remove(current);
                current = (Goal) data.getSerializableExtra("goal");
                tracingAdapter.add(current);
        }
    }

    public boolean isReady(){
        for(int i=0; i<tracingList.getChildCount(); i++){
            Goal g = (Goal) tracingList.getItemAtPosition(i);
            if(g.getImprovement() == null)
                return false;
        }
        return true;
    }

    public Goal[] getGoals(){
        Goal[] goals = new Goal[tracingList.getChildCount()];
        for(int i=0; i<tracingList.getChildCount(); i++)
            goals[i] = (Goal) tracingList.getItemAtPosition(i);
        return goals;
    }

    public int getPeriod(int n, int m){
        switch (n){
            case 1:
                return m / 12;
            case 2:
                return m / 6;
            case 4:
                return m / 3;
            case 6:
                return m / 2;
            case 12:
                return m;
            default:
                return -1;
        }
    }

}
