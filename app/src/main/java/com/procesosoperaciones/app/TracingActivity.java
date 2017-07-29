package com.procesosoperaciones.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TracingActivity extends AppCompatActivity {

    private TracingFragment tracingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing);

        tracingFragment = (TracingFragment) getSupportFragmentManager().findFragmentById(R.id.tracing_container);

        if(tracingFragment == null){
            tracingFragment = TracingFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.tracing_container, tracingFragment).commit();
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
        Toast.makeText(view.getContext(), "Not supported", Toast.LENGTH_LONG).show();
    }

}
