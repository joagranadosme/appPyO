package com.procesosoperaciones.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FinalEvaluationActivity extends AppCompatActivity {

    private FinalEvaluationFragment finalEvaluationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_evaluation);

        finalEvaluationFragment = (FinalEvaluationFragment) getSupportFragmentManager().findFragmentById(R.id.final_evaluation_container);

        if(finalEvaluationFragment == null){
            finalEvaluationFragment = FinalEvaluationFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.final_evaluation_container, finalEvaluationFragment).commit();
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
        Toast.makeText(view.getContext(), "Click", Toast.LENGTH_LONG).show();
    }

}
