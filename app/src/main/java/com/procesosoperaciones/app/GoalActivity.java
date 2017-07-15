package com.procesosoperaciones.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class GoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        BossFragment bossFragment = (BossFragment) getSupportFragmentManager().findFragmentById(R.id.boss_container);

        if(bossFragment == null){
            bossFragment = BossFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.boss_container, bossFragment).commit();
        }
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

    public void sendClick(View view){
        Toast.makeText(view.getContext(), "Send not supported.", Toast.LENGTH_SHORT).show();
    }

    public void deleteClick(View view){
        Toast.makeText(view.getContext(), "Delete not supported.", Toast.LENGTH_SHORT).show();
    }

    public void addClick(View view){
        Toast.makeText(view.getContext(), "Add not supported.", Toast.LENGTH_SHORT).show();
    }

}
