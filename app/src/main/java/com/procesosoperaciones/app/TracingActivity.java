package com.procesosoperaciones.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class TracingActivity extends AppCompatActivity {

    private Goal[] goals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing);

        try {
            goals = FileManager.readGoal(this);
            Toast.makeText(this, goals[0].toString(), Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(this, "No loaded", Toast.LENGTH_LONG).show();
            Log.e("Tracing", e.toString());
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

}
