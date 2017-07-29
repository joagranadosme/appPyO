package com.procesosoperaciones.app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class BossActivity extends AppCompatActivity {

    private BossFragment bossFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boss);

        bossFragment = (BossFragment) getSupportFragmentManager().findFragmentById(R.id.boss_container);

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
        Boss boss = bossFragment.getBoss();
        if(boss == null){
            Toast.makeText(view.getContext(), "¡Selecciona tu jefe!", Toast.LENGTH_LONG).show();
        }else {
            try{
                FileManager.writeBoss(boss, view.getContext());
            }catch (Exception e){
                Toast.makeText(view.getContext(), "¡Error guardando jefe!", Toast.LENGTH_LONG).show();
            }
            setResult(Activity.RESULT_OK);
            finish();
        }
    }

}
