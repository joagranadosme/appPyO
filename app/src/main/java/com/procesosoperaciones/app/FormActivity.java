package com.procesosoperaciones.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity {

    public static String[] perspectiveString = {"Financiera",
            "Interna",
            "Aprendizaje"
    };

    public Spinner perspectiveSpinner;
    public ArrayAdapter<String> perspectiveAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        perspectiveSpinner = (Spinner) findViewById(R.id.perspectiveSpinner);
        perspectiveAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, perspectiveString);
        perspectiveAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        perspectiveSpinner.setAdapter(perspectiveAdapter);

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
