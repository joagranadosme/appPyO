package com.procesosoperaciones.app;

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

    private final int GOAL_RESULT = 1;

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
                startActivityForResult(intent, GOAL_RESULT);
            }
        });

        return root;
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
