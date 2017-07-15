package com.procesosoperaciones.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class GoalFragment extends Fragment {

    private ListView goalList;
    private GoalAdapter goalAdapter;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.goal_fragment, container, false);
        goalList = (ListView) root.findViewById(R.id.goal_list);
        goalAdapter = new GoalAdapter(getActivity(), GoalRepository.getInstance().getGoals());
        goalList.setAdapter(goalAdapter);
        goalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Goal currentGoal = goalAdapter.getItem(position);
                Toast.makeText(getActivity(), position + "", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

}
