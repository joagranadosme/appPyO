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

public class GoalFragment extends Fragment {

    private Goal current;
    private ListView goalList;
    private TextView weightTextView;
    private GoalAdapter goalAdapter;

    private final int GOAL_RESULT = 1;

    public GoalFragment() {}

    public static GoalFragment newInstance(){
        GoalFragment fragment = new GoalFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){

        View root = inflater.inflate(R.layout.goal_fragment, container, false);

        weightTextView = (TextView) root.findViewById(R.id.weightText);

        goalList = (ListView) root.findViewById(R.id.goal_list);
        goalAdapter = new GoalAdapter(getActivity(), GoalRepository.getInstance(getContext()).getGoals());
        goalList.setAdapter(goalAdapter);
        goalList.setLongClickable(true);

        goalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                current = goalAdapter.getItem(position);
                Intent intent = new Intent(getActivity(), FormActivity.class);
                intent.putExtra("goal", current);
                startActivityForResult(intent, GOAL_RESULT);
            }
        });

        goalList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                current = goalAdapter.getItem(position);
                goalAdapter.remove(current);
                return true;
            }
        });

        //weightTextView.setText(getTotalWeight() + "%");
        return root;
    }

    public boolean sendClick(){
        return getTotalWeight() != 100 ? false : true;
    }

    public void addClick(){
        goalAdapter.add(new Goal());
        goalAdapter.notifyDataSetChanged();
    }

    public int getTotalWeight(){
        int total = 0;
        for(int i=0; i<goalAdapter.getCount(); i++)
            total += goalAdapter.getItem(i).getWeight();
        return total;
    }

    public Goal[] getGoals(){
        Goal[] goals = new Goal[goalAdapter.getCount()];
        for(int i=0; i<goals.length; i++)
            goals[i] = goalAdapter.getItem(i);
        return goals;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GOAL_RESULT){
            if(resultCode == Activity.RESULT_OK){
                goalAdapter.remove(current);
                current = (Goal) data.getSerializableExtra("goal");
                goalAdapter.add(current);
                //weightTextView.setText(getTotalWeight() + "%");
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        weightTextView.setText(getTotalWeight() + "%");
    }
}