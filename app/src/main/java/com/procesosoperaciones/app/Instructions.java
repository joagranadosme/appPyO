package com.procesosoperaciones.app;

import android.app.Activity;
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

public class Instructions extends AppCompatActivity {

    private static final int SELECT_BOSS = 0;

    private int id;
    private Intent intent;
    private String[] titles = {"Seleccionar jefe directo", "Fijar objetivos", "Evaluar competencias", "Seguimiento", "Evaluación"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        //Get info.
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");

        //Set fonts.
        DocumentView content = (DocumentView) findViewById(R.id.contentDocumentView);
        getSupportActionBar().setTitle(titles[id]);

        switch (id) {
            case 0:
                content.setText(getResources().getText(R.string.instruction_0));
                break;
            case 1:
                content.setText(getResources().getText(R.string.instruction_1));
                break;
            case 2:
                content.setText(getResources().getText(R.string.instruction_2));
                break;
            case 3:
                content.setText(getResources().getText(R.string.instruction_3));
                break;
            case 4:
                content.setText(getResources().getText(R.string.instruction_4));
                break;
            default:

                break;
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
        switch (id) {
            case 0:
                intent = new Intent(view.getContext(), BossActivity.class);
                startActivityForResult(intent, SELECT_BOSS);
                break;
            case 1:
                intent = new Intent(view.getContext(), GoalActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(view.getContext(), "Not supported yet.", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_BOSS && resultCode == Activity.RESULT_OK) {
            setResult(Activity.RESULT_OK);
            finish();
        }
    }

}
