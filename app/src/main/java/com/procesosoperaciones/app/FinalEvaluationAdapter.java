package com.procesosoperaciones.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jonathan on 7/14/2017.
 */

public class FinalEvaluationAdapter extends ArrayAdapter<Goal> {

    public FinalEvaluationAdapter(Context context, List<Goal> goals){
        super(context, 0, goals);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if(null == convertView){
            convertView = inflater.inflate(R.layout.list_item_goal, parent, false);
            holder = new ViewHolder();
            holder.perspective = (TextView) convertView.findViewById(R.id.perspective);
            holder.strategic = (TextView) convertView.findViewById(R.id.strategic);
            holder.weight = (TextView) convertView.findViewById(R.id.weight);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Goal goal = getItem(position);

        holder.perspective.setText(goal.getPerspective());
        holder.strategic.setText(goal.getStrategicGoal());
        holder.weight.setText("TESTING");

        return convertView;
    }

    static class ViewHolder{
        TextView perspective;
        TextView strategic;
        TextView weight;
    }

}
