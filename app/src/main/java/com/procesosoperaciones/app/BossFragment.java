package com.procesosoperaciones.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class BossFragment extends Fragment {

    private ListView bossList;
    private BossAdapter bossAdapter;

    public BossFragment() {}

    public static BossFragment newInstance(){
        BossFragment fragment = new BossFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments() != null){}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.boss_fragment, container, false);
        bossList = (ListView) root.findViewById(R.id.boss_list);
        bossAdapter = new BossAdapter(getActivity(), BossRepository.getInstance().getBosses());
        bossList.setAdapter(bossAdapter);
        bossList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Boss currentBoss = bossAdapter.getItem(i);
                Toast.makeText(getActivity(), currentBoss.getName(), Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }

}
