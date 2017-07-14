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

public class GeneralInstructions extends AppCompatActivity {

    private String text = ("Bienvenido al Sistema de Gestión de Desempeño.\n"+
            "\n"+
            "La presente herramienta, le permitirá desarrollar cada una de las fases y componentes del Sistema de Gestión de Desempeño que nuestra app coloca a su disposición.\n"+
            "\n"+
            "El proceso se desarrollará de una manera secuencial, con el fin de que usted vaya revisando la evolución de su gestión a lo largo del tiempo que dure el ciclo de gestión de desempeño.\n"+
            "\n"+
            "Tenga en cuenta las siguientes recomendaciones:\n"+
            "\n"+
            "1. Es muy importante que diligencie toda la información requerida a lo largo del proceso, para que la verifique con su jefe inmediato.\n"+
            "\n"+
            "2. Cada Fase tiene una fecha inicio y una fecha fin, las cuales serán informadas por el area administradora del proceso.\n"+
            "\n"+
            "3. No olvide tener la información de sustento para el diligenciamiento de los objetivos, metas, indicadores y pesos porcentuales de importancia sobre cada objetivo, que  usted ha definido junto con su jefe inmediato. En caso de requerirse el área administradora del Proceso, le solicitará dichos soportes, en caso que surjan inquietudes sobre la información consignada.\n"+
            "\n"+
            "4. El formato contiene la formulación que les permitirá a usted y su jefe inmediato, obtener la información referente a la calificación obtenida en cada uno de los objetivos definidos, asi como la calificación ponderada final de Gestión de Desempeño.\n"+
            "\n"+
            "5. En caso de requerir ayuda o soporte, por favor contáctese con:\n"+
            "Telefono:\n"+
            "\n"+
            "6. A continuación encontrará los siguientes pasos que deberá desarrollar a lo largo del ciclo de Gestión de Desempeño de manera secuencial, por favor haga click en el botón que requiera.");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_instructions);

        //Set fonts.
        TextView instruccionesView = (TextView) findViewById(R.id.instruccionesText);
        instruccionesView.setText(text);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Calibri.ttf");
        instruccionesView.setTypeface(font);
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
