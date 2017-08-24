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
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

public class FinalEvaluationFragment extends Fragment {

    private Goal current;
    private ListView finalList;
    private FinalEvaluationAdapter finalEvaluationAdapter;

    private final int FINAL_EVAL = 3;

    public FinalEvaluationFragment() {}

    public static FinalEvaluationFragment newInstance(){
        FinalEvaluationFragment fragment = new FinalEvaluationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_final_evaluation, container, false);

        finalList = (ListView) root.findViewById(R.id.final_list);
        finalEvaluationAdapter = new FinalEvaluationAdapter(getActivity(), GoalRepository.getInstance(getContext()).getGoals());
        finalList.setAdapter(finalEvaluationAdapter);
        finalList.setLongClickable(true);

        finalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                current = finalEvaluationAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), FinalEvaluationDetail.class);
                intent.putExtra("goal", current);
                startActivityForResult(intent, FINAL_EVAL);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


}
