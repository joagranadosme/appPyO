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

public class TracingFragment extends Fragment {

    private Goal current;
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

        tracingList = (ListView) root.findViewById(R.id.tracing_list);
        tracingAdapter = new TracingAdapter(getActivity(), GoalRepository.getInstance(getContext()).getGoals());
        tracingList.setAdapter(tracingAdapter);
        tracingList.setLongClickable(true);

        tracingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                current = tracingAdapter.getItem(position);
                //Intent intent = new Intent(getActivity(), FormActivity.class);
                //intent.putExtra("goal", current);
                //startActivityForResult(intent, GOAL_RESULT);
            }
        });

        return root;
    }

}
