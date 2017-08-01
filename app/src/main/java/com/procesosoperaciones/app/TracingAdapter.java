package com.procesosoperaciones.app;

import android.content.Context;
import android.graphics.Color;
import android.icu.util.TimeZone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jonathan on 7/28/2017.
 */

public class TracingAdapter extends ArrayAdapter<Goal> {

    private static HashMap<Integer, String> map;
    private Calendar calendar;

    static{
        map = new HashMap<Integer, String>();
        map.put(1, "Año #");
        map.put(2, "Semestre #");
        map.put(4, "Trimestre #");
        map.put(6, "Bimestre #");
        map.put(12, "Mes #");
    }

    public TracingAdapter(Context context, List<Goal> goals){
        super(context, 0, goals);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_item_tracing, parent, false);
            holder = new ViewHolder();
            holder.perspective = (TextView) convertView.findViewById(R.id.perspective);
            holder.strategic = (TextView) convertView.findViewById(R.id.strategic);
            holder.period = (TextView) convertView.findViewById(R.id.period);
            holder.score = (TextView) convertView.findViewById(R.id.score);
            holder.grade = (TextView) convertView.findViewById(R.id.grade);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Goal goal = getItem(position);
        calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        int period = getPeriod(goal.getGoalTracing().length, month);
        int score = (int) (Math.random() * 100);

        holder.perspective.setText(goal.getPerspective());
        holder.strategic.setText(goal.getStrategicGoal());
        holder.period.setText(map.get(goal.getGoalTracing().length) + (period+1));
        holder.score.setText(score + "%");

        if(score < 60){
            holder.grade.setText("Malo");
            holder.grade.setBackgroundColor(Color.RED);
        }else if(score < 80) {
            holder.grade.setText("Aceptable");
            holder.grade.setBackgroundColor(Color.YELLOW);
        }else if(score < 100) {
            holder.grade.setText("Bueno");
            holder.grade.setBackgroundColor(Color.GREEN);
        }else {
            holder.grade.setText("¡Excelente!");
            holder.grade.setBackgroundColor(Color.CYAN);
        }

        return convertView;
    }

    public int getPeriod(int n, int m){
        switch (n){
            case 1:
                return m / 12;
            case 2:
                return m / 6;
            case 4:
                return m / 3;
            case 6:
                return m / 2;
            case 12:
                return m;
            default:
                return -1;
        }
    }

    static class ViewHolder{
        TextView perspective;
        TextView strategic;
        TextView period;
        TextView score;
        TextView grade;
    }
}
