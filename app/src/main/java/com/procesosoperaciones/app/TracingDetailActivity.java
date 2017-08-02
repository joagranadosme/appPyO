package com.procesosoperaciones.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.style.JustifiedSpan;
import com.bluejamesbond.text.util.ArticleBuilder;

public class TracingDetailActivity extends AppCompatActivity {

    Goal goal;
    int period;
    EditText improve;
    ArticleBuilder articleBuilder;
    DocumentView generalDocumentView;
    DocumentView commentDocumentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracing_detail);

        Intent intent = getIntent();
        goal = (Goal) intent.getSerializableExtra("goal");
        period = intent.getIntExtra("period", -1);

        improve = (EditText) findViewById(R.id.improveEditText);
        if(goal.getImprovement() == null)
            improve.setText("Escribe aquí tu plan de mejoramiento.");
        else
            improve.setText(goal.getImprovement());

        int result = goal.getGoalEvaluated()[period];
        int proposed = goal.getGoalTracing()[period];
        int total = (int)((result / proposed) * 100);

        TextView resultText  = (TextView) findViewById(R.id.resultText);
        TextView proposedText = (TextView) findViewById(R.id.proposedText);
        TextView totalText = (TextView) findViewById(R.id.totalText);
        TextView scoreText = (TextView) findViewById(R.id.scoreText);

        resultText.setText(result + "");
        proposedText.setText(proposed + "");
        totalText.setText(total + "");
        scoreText.setText(getTotalText(total));
        scoreText.setBackgroundColor(getTotalColor(total));

        generalDocumentView = (DocumentView) findViewById(R.id.generalDocumentView);
        commentDocumentView = (DocumentView) findViewById(R.id.commentDocumentView);

        articleBuilder = new ArticleBuilder();
        articleBuilder
            .append("<b>Perspectiva: </b>" + goal.getPerspective() + ".\n", true, new RelativeSizeSpan(1.3f), new JustifiedSpan())
            .append("<b>Objetivo: </b>" + goal.getStrategicGoal() + ".\n", true, new RelativeSizeSpan(1.3f), new JustifiedSpan())
            .append("<b>Indicador: </b>" + goal.getIndicator() + ".\n", true, new RelativeSizeSpan(1.3f), new JustifiedSpan())
            .append("<b>Frente de gestión: </b>" + goal.getManagementFront() + ".\n", true, new RelativeSizeSpan(1.3f), new JustifiedSpan())
        ;
        generalDocumentView.setText(articleBuilder);

        articleBuilder = new ArticleBuilder();
        articleBuilder.append("El trabajador cumple con su trabajo.", true, new RelativeSizeSpan(1.3f), new JustifiedSpan());
        commentDocumentView.setText(articleBuilder);
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
        if(improve.getText().toString().equals(""))
            Toast.makeText(view.getContext(), "¡El plan de mejoramiento no puede estar vacío!", Toast.LENGTH_LONG).show();
        else{
            goal.setImprovement(improve.getText().toString());
            Intent returnIntent = new Intent();
            returnIntent.putExtra("goal", goal);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }

    }

    public String getTotalText(int score){
        if(score < 60)
            return "Malo";
        else if(score < 80)
            return "Aceptable";
        else if(score < 100)
            return "Bueno";
        else
            return "¡Excelente!";
    }

    public int getTotalColor(int score){
        if(score < 60)
            return Color.RED;
        else if(score < 80)
            return Color.YELLOW;
        else if(score < 100)
            return Color.GREEN;
        else
            return Color.CYAN;

    }

}

