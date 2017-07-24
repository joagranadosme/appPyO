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
import android.widget.Toast;

public class GoalFragment extends Fragment {

    private Goal current;
    private ListView goalList;
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
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.goal_fragment, container, false);
        goalList = (ListView) root.findViewById(R.id.goal_list);
        goalAdapter = new GoalAdapter(getActivity(), GoalRepository.getInstance().getGoals());
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
        return root;
    }

    public void sendClick(View view){
        Toast.makeText(view.getContext(), "Send not supported.", Toast.LENGTH_SHORT).show();
    }

    public void addClick(View view){
        goalAdapter.add(new Goal());
        goalAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == GOAL_RESULT){
            if(resultCode == Activity.RESULT_OK){
                goalAdapter.remove(current);
                current = (Goal) data.getSerializableExtra("goal");
                goalAdapter.add(current);
            }
        }
    }

}