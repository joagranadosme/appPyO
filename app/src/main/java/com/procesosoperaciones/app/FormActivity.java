package com.procesosoperaciones.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private int size;
    private Goal goal;

    private static String[] perspectiveString = {"Financiera", "Interna", "Aprendizaje"};
    private static String[] strategicString = {"Generar valor", "Operar de manera limpia y segura", "Asegurar integridad"};
    private static String[] indicatorString = {"Ejecucion presupuestal", "Asegurar estructura organizacional", "Índice de Frecuencia"};
    private static String[] frontString = {"Frente de gestión", "Asegurar el fondeo oportuno de recursos", "Promover el proyecto ante mercados nacionales",  "Obtener una adecuada cobertura",  "Implementación del Programa Local", "Contratos con terceros"};
    private static String[] typeString = {"Individual", "Grupal", "Desarrollo de capacidades"};
    private static String[] periodString = {"Periodo", "Mensual", "Bimestral", "Trimestral", "Semestral", "Anual"};

    private Spinner perspectiveSpinner;
    private Spinner strategicSpinner;
    private Spinner indicatorSpinner;
    private Spinner frontSpinner;
    private Spinner typeSpinner;
    private Spinner periodSpinner;

    private ArrayAdapter<String> perspectiveAdapter;
    private ArrayAdapter<String> strategicAdapter;
    private ArrayAdapter<String> indicatorAdapter;
    private ArrayAdapter<String> frontAdapter;
    private ArrayAdapter<String> typeAdapter;
    private ArrayAdapter<String> periodAdapter;

    private EditText responsabilityEditText;
    private EditText redactionEditText;
    private EditText weightEditText;

    private RadioButton measureYes;
    private RadioButton measureNo;
    private RadioButton managementYes;
    private RadioButton managementNo;
    private RadioButton unitYes;
    private RadioButton unitNo;
    private RadioButton indicatorYes;
    private RadioButton indicatorNo;

    private LinearLayout.LayoutParams layoutParams;
    private LinearLayout goalsLinearLayout;

    private TextView[] goalsTextView;
    private EditText[] goalsEditText;
    private LinearLayout[] goalLinearLayout;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);

        perspectiveSpinner = (Spinner) findViewById(R.id.perspectiveSpinner);
        perspectiveAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, perspectiveString);
        perspectiveAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        perspectiveSpinner.setAdapter(perspectiveAdapter);

        strategicSpinner = (Spinner) findViewById(R.id.strategicSpinner);
        strategicAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, strategicString);
        strategicAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        strategicSpinner.setAdapter(strategicAdapter);

        indicatorSpinner = (Spinner) findViewById(R.id.indicatorSpinner);
        indicatorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, indicatorString);
        indicatorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        indicatorSpinner.setAdapter(indicatorAdapter);

        frontSpinner = (Spinner) findViewById(R.id.frontSpinner);
        frontAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frontString);
        frontAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frontSpinner.setAdapter(frontAdapter);

        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeString);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        periodSpinner = (Spinner) findViewById(R.id.periodSpinner);
        periodAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, periodString);
        periodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        periodSpinner.setAdapter(periodAdapter);
        periodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                if(goal.getGoalTracing() != null){
                    add(goal.getGoalTracing().length, goal.getPeriod(), goal.getGoalTracing());
                    goal.setGoalTracing(null);
                }else{
                    String selectedItem = parent.getItemAtPosition(position).toString();
                    if (selectedItem.equals(periodString[1]))
                        add(12, "Mes", new int[12]);
                    else if (selectedItem.equals(periodString[2]))
                        add(6, "Bimestre", new int[6]);
                    else if (selectedItem.equals(periodString[3]))
                        add(4, "Trimestre", new int[4]);
                    else if (selectedItem.equals(periodString[4]))
                        add(2, "Semestre", new int[2]);
                    else if (selectedItem.equals(periodString[5]))
                        add(1, "Año", new int[1]);
                    else
                        add(1, "Periodo", new int[1]);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        measureYes = (RadioButton) findViewById(R.id.measureYesRadio);
        measureNo = (RadioButton) findViewById(R.id.measureNoRadio);

        managementYes = (RadioButton) findViewById(R.id.managementYesRadio);
        managementNo = (RadioButton) findViewById(R.id.managementNoRadio);

        unitYes = (RadioButton) findViewById(R.id.unitYesRadio);
        unitNo = (RadioButton) findViewById(R.id.unitNoRadio);

        indicatorYes = (RadioButton) findViewById(R.id.indicatorTypeYesRadio);
        indicatorNo = (RadioButton) findViewById(R.id.indicatorTypeNoRadio);

        responsabilityEditText = (EditText) findViewById(R.id.respEditText);
        redactionEditText = (EditText) findViewById(R.id.redactionEditText);
        weightEditText = (EditText) findViewById(R.id.weightNumber);

        goalsLinearLayout = (LinearLayout) findViewById(R.id.goalsLinearLayout);


        Intent intent = getIntent();
        goal = (Goal) intent.getSerializableExtra("goal");

        if(!goal.getPerspective().equals(""))
            perspectiveSpinner.setSelection(perspectiveAdapter.getPosition(goal.getPerspective()));

        if(goal.getStrategicGoal() != null)
            strategicSpinner.setSelection(strategicAdapter.getPosition(goal.getStrategicGoal()));

        if(goal.getIndicator() != null)
            indicatorSpinner.setSelection(indicatorAdapter.getPosition(goal.getIndicator()));

        if(goal.getManagementFront() != null)
            frontSpinner.setSelection(frontAdapter.getPosition(goal.getManagementFront()));

        if(goal.getType() != null)
            typeSpinner.setSelection(typeAdapter.getPosition(goal.getType()));

        if(goal.getPeriod() != null)
            periodSpinner.setSelection(periodAdapter.getPosition(goal.getPeriod()));

        if(goal.isMeasure()){
            measureYes.setChecked(true);
            measureNo.setChecked(false);
        }else {
            measureYes.setChecked(false);
            measureNo.setChecked(true);
        }

        if(goal.isManagement()){
            managementYes.setChecked(true);
            managementNo.setChecked(false);
        }else{
            managementYes.setChecked(false);
            managementNo.setChecked(true);
        }

        if(goal.isUnit()){
            unitYes.setChecked(true);
            unitNo.setChecked(false);
        }else{
            unitYes.setChecked(false);
            unitNo.setChecked(true);
        }

        if(goal.isIndicatorType()){
            indicatorYes.setChecked(true);
            indicatorNo.setChecked(false);
        }else{
            indicatorYes.setChecked(false);
            indicatorNo.setChecked(true);
        }

        if(goal.getResponsibility() != null)
            responsabilityEditText.setText(goal.getResponsibility());

        if(goal.getRedaction() != null)
            redactionEditText.setText(goal.getRedaction());

        weightEditText.setText(goal.getWeight() + "");
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

        boolean flag = true;

        String perspective = perspectiveSpinner.getSelectedItem().toString();
        goal.setPerspective(perspective);

        String strategic = strategicSpinner.getSelectedItem().toString();
        goal.setStrategicGoal(strategic);

        String indicator = indicatorSpinner.getSelectedItem().toString();
        goal.setIndicator(indicator);

        String front = frontSpinner.getSelectedItem().toString();
        goal.setManagementFront(front);

        String type = typeSpinner.getSelectedItem().toString();
        goal.setType(type);

        String period = periodSpinner.getSelectedItem().toString();
        goal.setPeriod(period);

        String responsability = responsabilityEditText.getText().toString();
        if(responsability.equals("")){
            flag = false;
            Toast.makeText(view.getContext(), "¡La responsabilidad de tu objetivo no puede estar vacía!", Toast.LENGTH_LONG).show();
        }else{
            goal.setResponsibility(responsability);
        }

        String redaction = redactionEditText.getText().toString();
        if(redaction.equals("")){
            flag = false;
            Toast.makeText(view.getContext(), "¡La descripción de tu objetivo no puede estar vacía!", Toast.LENGTH_LONG).show();
        }else{
            goal.setRedaction(redaction);
        }

        boolean measure = measureYes.isChecked();
        goal.setMeasure(measure);

        boolean management = managementYes.isChecked();
        goal.setManagement(management);

        boolean unit = unitYes.isChecked();
        goal.setUnit(unit);

        boolean indicatorType = indicatorYes.isChecked();
        goal.setIndicatorType(indicatorType);

        int weight;
        try{
            weight = Integer.parseInt(weightEditText.getText().toString());
            goal.setWeight(weight);
        }catch (Exception e){
            flag = false;
            Toast.makeText(view.getContext(), "¡Debes asignar un porcentaje a tu objetivo!", Toast.LENGTH_LONG).show();
        }

        int[] goals = new int[size];
        int[] evaluated = new int[size];
        try {
            for(int i=0; i<size; i++) {
                goals[i] = Integer.parseInt(goalsEditText[i].getText().toString());
                evaluated[i] = (int)(Math.random() * 100);
            }
            goal.setGoalTracing(goals);
            goal.setGoalEvaluated(evaluated);
        }catch (Exception e){
            flag = false;
            Toast.makeText(view.getContext(), "¡Debes asignar una meta para cada periodo!", Toast.LENGTH_LONG).show();
        }

        if(flag) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("goal", goal);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }

    public void add(int n, String s, int[] g){
        size = n;
        goalsLinearLayout.removeAllViews();

        goalLinearLayout = new LinearLayout[n];
        goalsTextView = new TextView[n];
        goalsEditText = new EditText[n];

        for(int i=0; i<n; i++) {
            goalLinearLayout[i] = new LinearLayout(this);
            goalLinearLayout[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            goalLinearLayout[i].setOrientation(LinearLayout.HORIZONTAL);

            goalsTextView[i] = new TextView(this);
            goalsTextView[i].setText(s + " #" + (i+1) + ": ");
            goalsTextView[i].setGravity(Gravity.RIGHT);
            goalsTextView[i].setLayoutParams(layoutParams);
            goalLinearLayout[i].addView(goalsTextView[i]);

            goalsEditText[i] = new EditText(this);
            goalsEditText[i].setText(g[i] + "");
            goalsEditText[i].setInputType(InputType.TYPE_CLASS_NUMBER);
            goalsEditText[i].setLayoutParams(layoutParams);
            goalLinearLayout[i].addView(goalsEditText[i]);

            goalsLinearLayout.addView(goalLinearLayout[i]);
        }
    }

    public void measureYesClick(View view){
        measureNo.setChecked(false);
    }

    public void measureNoClick(View view){
        measureYes.setChecked(false);
    }

    public void managementYesClick(View view){
        managementNo.setChecked(false);
    }

    public void managementNoClick(View view){
        managementYes.setChecked(false);
    }

    public void unitYesClick(View view){
        unitNo.setChecked(false);
    }

    public void unitNoClick(View view){
        unitYes.setChecked(false);
    }

    public void indicatorTypeYesClick(View view){
        indicatorNo.setChecked(false);
    }

    public void indicatorTypeNoClick(View view){
        indicatorYes.setChecked(false);
    }

}
