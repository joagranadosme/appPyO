package com.procesosoperaciones.app;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;

public class GeneralInstructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_instructions);

        DocumentView content = (DocumentView) findViewById(R.id.instruccionesDocumentView);
        content.setText(getResources().getText(R.string.general_instructions_text));
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

    public void unoClick(View view){
        //Start new activity.
        Intent intent = new Intent(this, Instructions.class);
        intent.putExtra("id", 0);
        startActivity(intent);
    }

    public void dosClick(View view){
        //Start new activity.
        Intent intent = new Intent(this, Instructions.class);
        intent.putExtra("id", 1);
        startActivity(intent);
    }

    public void tresClick(View view){
        //Start new activity.
        Intent intent = new Intent(this, Instructions.class);
        intent.putExtra("id", 2);
        startActivity(intent);
    }

    public void cuatroClick(View view){
        //Start new activity.
        Intent intent = new Intent(this, Instructions.class);
        intent.putExtra("id", 3);
        startActivity(intent);
    }

    public void cincoClick(View view){
        //Start new activity.
        Intent intent = new Intent(this, Instructions.class);
        intent.putExtra("id", 4);
        startActivity(intent);
    }

}
