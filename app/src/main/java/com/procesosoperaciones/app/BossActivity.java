package com.procesosoperaciones.app;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                Log.e("BossActivity", "Error writting boss.");
            }
            new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Selección de jefe")
                .setMessage("¿Estás seguro de elegir a " + boss.getName() + " como tu jefe?\n")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setResult(Activity.RESULT_OK);
                        finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
        }
    }

}
