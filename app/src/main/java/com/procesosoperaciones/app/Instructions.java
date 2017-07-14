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

public class Instructions extends AppCompatActivity {

    private int id;
    private String[] titles = {"Seleccionar jefe directo", "Fijar objetivos", "Evaluar competencias", "Seguimiento", "Evaluación"};
    private String[] contents = {
            "Apreciado Colaborador.\n" +
                    "\n" +
                    "A continuación encontrará una lista desplegable de los funcionarios de la empresa que pueden evaluar a otros a su cargo dentro del proceso del Sistema de Gestión de Desempeño.\n" +
                    "\n" +
                    "Por favor tenga en cuenta que la persona que usted seleccione, esté permanentemente direccionando su trabajo, retroalimentándolo y apoyándolo en la solución de problemas u obstaculos que se le puedan presentar dentro del desarrollo diario de sus actividades que lo estan conduciendo al logro de los retos que usted ha definido y validará con la persona que seleccionará a continuación",
            "Apreciado Colaborador.\n" +
                    "\n" +
                    "Bienvenido(a) a la Fase 2 del Sistema de Gestión de Desempeño denominada FASE DE FIJACIÓN DE OBJETIVOS.\n" +
                    "\n" +
                    "Para desarrollar esta Fase, además de haber asistido a los talleres de la metodología del Sistema de gestión de Desempeño, usted deberá tener la siguiente información disponible:\n" +
                    "1. La Descripción de su cargo.\n" +
                    "2. Los Objetivos de su área.\n" +
                    "3. Los Objetivos de su Jefe inmediato.\n" +
                    "4. Tener claro como es el modelo de competencias y como su cargo se involucra dentro de este modelo.\n" +
                    "5. Conocer el material con el cual usted puede identificar los planes de mejoramiento asociados a las competencias, de acuerdo con las intrucciones dadas por el área de Recursos Humanos.\n" +
                    "\n" +
                    "Con base en lo anterior, usted podrá:\n" +
                    "1. Identificar sus frentes de gestión y los requerimientos especificos de sus cliente (interno o externo), a partir de los cuales usted podrá Identificar, proponer y acordar con su jefe inmediato, los objetivos que desarrollará en el ciclo de gestión de desempeño del año en curso.\n" +
                    "2. Evaluar las competencias definidas por Venus Colombiana S.A, a nivel general para todos los cargos y en específico para su cargo, con base en lo cual usted junto con su jefe inmediato, podrán definir los planes de mejoramiento asociados a las competencias que usted deberá desarrollar dentro del ciclo de gestión de desempeño.",
            "Apreciado Colaborador.\n" +
                    "\n" +
                    "No text.",
            "Apreciado Colaborador.\n" +
                    "\n" +
                    "Bienvenido(a) a la Fase 3 del Sistema de Gestión de Desempeño denominada SEGUIMIENTO DE OBJETIVOS.\n" +
                    "\n" +
                    "En esta fase usted se deberá reunir con su jefe inmediato, para realizar una REUNION DE SEGUIMIENTO FORMAL, a la fecha de corte definido por VENUS COLOMBIANA S.A, para determinar el grado de avance de los objetivos acordados en la Fase 2. Asi mismo revisarán las evidencias de los Planes de Mejoramiento definidos para las competencias sobre las cuales se haya decidido trabajar a lo largo del año.\n" +
                    "\n" +
                    "Para desarrollar esta Fase, usted deberá tener la siguiente información disponible:\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "1. Cálculo de ejecución a la fecha de corte de cada uno de los objetivos definidos previamente en la Fase 2 - Fijación de Objetivos.\n" +
                    "2. Evidencias del desarrollo de las competencias.\n" +
                    "\n" +
                    "Con base en esta información, por favor haga lo siguiente en el formato definido:\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "1. Incluya el valor de la ejecución en la columna correspondiente en cada objetivo\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "2. La Herramienta le calculará el cumplimiento para cada objetivo forma automática. De acuerdo con la formula correspondiente al tipo de indicador seleccionado.\n" +
                    "3. En caso que el cumplimiento calculado, sea menor a 80% (semaforizado en rojo), por favor digite un plan de mejoramiento para el objetivo que corresponda.\t\t\t\t\t\t\t\t\t\n" +
                    "4. Posteriormente revise los planes de mejoramiento definidos para las competencias que usted y su jefe inmediato hayan considerado desarrollar.\t\t\t\t\t\t\t\n" +
                    "5. Guarde el formato en su PC y envíeselo a su jefe inmediato.\n" +
                    "6. Reúnase y revise con su jefe inmediato, la información aquí consignada, para recibir retroalimentación sobre los resultados finales obtenidos.\n" +
                    "7. Por favor imprima y fírme el formato, hagalo firmar de su jefe y envíelo al area de Recursos Humanos.",
            "Apreciado Colaborador.\n" +
                    "\n" +
                    "Bienvenido(a) a la Fase 4 del Sistema de Gestión de Desempeño denominada EVALUACION FINAL DE OBJETIVOS.\n" +
                    "\n" +
                    "En esta fase usted se deberá reunir con su jefe inmediato, para realizar una la EVALUACION FORMAL DE GESTION DE DESEMPEÑO, CORRESPONDIENTE AL AÑO 2011, en la cual se debe establecer el resultado final de ejecución de los objetivos acordados en la Fase 2. Asi mismo revisarán las evidencias faltantes de los Planes de Mejoramiento definidos para las competencias sobre las cuales se haya decidido trabajar a lo largo del año.\n" +
                    "\n" +
                    "Para desarrollar esta Fase, usted deberá tener la siguiente información disponible:\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "1. Calculo de ejecución al cierre de Dic 31, para cada uno de los objetivos definidos previamente en la Fase 2 - Fijación de Objetivos.\n" +
                    "2. Evidencias del desarrollo de las competencias.\n" +
                    "\n" +
                    "Con base en esta información, por favor haga lo siguiente en el formato definido:\t\t\t\t\t\t\t\t\t\t\t\n" +
                    "1. Incluya el valor de la ejecución en la columna correspondiente en cada objetivo.\n" +
                    "2. La Herramienta le calculará el cumplimiento para cada objetivo forma automática. De acuerdo con la formula correspondiente al tipo de indicador seleccionado.\n" +
                    "3. Para cumplimientos por debajo del 80% (semaforizado en rojo), por favor revise las causas por las cuales no se logró el objetivo.\n" +
                    "4. Posteriormente revise los planes de mejoramiento definidos para las competencias que usted y su jefe inmediato hayan considerado desarrollar.\n" +
                    "5. Diligencie la información correspondiente a necesidades de formación que le permitan el logro de sus objetivos o su desarrollo.\t\t\t\t\t\t\t\n" +
                    "6. Guarde el formato en su PC y envíeselo a su jefe inmediato.\t\t\t\t\t\t\t\t\t\n" +
                    "7. Reúnase y revise con su jefe inmediato, la información aquí consignada, para recibir retroalimentación sobre los resultados finales obtenidos.\n" +
                    "8. Por favor imprima y fírme el formato, hagalo firmar de su jefe y envíelo al area de Recursos Humanos."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        //Get info.
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        TextView content = (TextView) findViewById(R.id.contentTextView);

        //Set fonts.
        getSupportActionBar().setTitle(titles[id]);
        content.setText(contents[id]);
        Typeface font = Typeface.createFromAsset(getAssets(), "font/Calibri.ttf");
        content.setTypeface(font);
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

    public void nextClick(View view){
        switch (id) {
            case 0:
                Intent intent = new Intent(view.getContext(), BossActivity.class);
                startActivity(intent);
            default:
                Toast.makeText(view.getContext(), "Not supported yet.", Toast.LENGTH_SHORT).show();
        }

    }


}
