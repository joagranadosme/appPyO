package com.procesosoperaciones.app;

import android.os.Build;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Jonathan on 7/13/2017.
 */

public class Goal implements Serializable {

    private String id;
    private String perspective = null;
    private String strategicGoal = null;
    private String indicator = null;
    private String managementFront = null;
    private String type = null;
    private String responsibility = null;
    private String redaction = null;
    private boolean measure = true;
    private boolean management = true;
    private int weight = -1;
    private boolean unit = true;
    private boolean indicatorType = true;
    private String formula = null;
    private String period = null;
    private int[] goalTracing = null;
    private int[] goalEvaluated = null;

    public Goal() {
        this.id = UUID.randomUUID().toString();
        this.perspective = "Nuevo objetivo";
        this.strategicGoal = "Objetivo estratégico";
        this.weight = 0;
    }

    public Goal(String perspective, int weight, String strategicGoal){
        this.id = UUID.randomUUID().toString();
        this.perspective = perspective;
        this.weight = weight;
        this.strategicGoal = strategicGoal;
    }

    public Goal(String perspective, String strategicGoal, String indicator, String managementFront, String type, String responsibility, String redaction, boolean measure, boolean management, int weight, boolean unit, boolean indicatorType, String formula, int[] goalTracing, int[] goalEvaluated) {
        this.id = UUID.randomUUID().toString();
        this.perspective = perspective;
        this.strategicGoal = strategicGoal;
        this.indicator = indicator;
        this.managementFront = managementFront;
        this.type = type;
        this.responsibility = responsibility;
        this.redaction = redaction;
        this.measure = measure;
        this.management = management;
        this.weight = weight;
        this.unit = unit;
        this.indicatorType = indicatorType;
        this.formula = formula;
        this.goalTracing = goalTracing;
        this.goalEvaluated = goalEvaluated;
    }

    public Goal(String id, String perspective, String strategicGoal, String indicator, String managementFront, String type, String responsibility, String redaction, boolean measure, boolean management, int weight, boolean unit, boolean indicatorType, String formula, int[] goalTracing, int[] goalEvaluated) {
        this.id = id;
        this.perspective = perspective;
        this.strategicGoal = strategicGoal;
        this.indicator = indicator;
        this.managementFront = managementFront;
        this.type = type;
        this.responsibility = responsibility;
        this.redaction = redaction;
        this.measure = measure;
        this.management = management;
        this.weight = weight;
        this.unit = unit;
        this.indicatorType = indicatorType;
        this.formula = formula;
        this.goalTracing = goalTracing;
        this.goalEvaluated = goalEvaluated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPerspective() {
        return perspective;
    }

    public void setPerspective(String perspective) {
        this.perspective = perspective;
    }

    public String getStrategicGoal() {
        return strategicGoal;
    }

    public void setStrategicGoal(String strategicGoal) {
        this.strategicGoal = strategicGoal;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getManagementFront() {
        return managementFront;
    }

    public void setManagementFront(String managementFront) {
        this.managementFront = managementFront;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getRedaction() {
        return redaction;
    }

    public void setRedaction(String redaction) {
        this.redaction = redaction;
    }

    public boolean isMeasure() {
        return measure;
    }

    public void setMeasure(boolean measure) {
        this.measure = measure;
    }

    public boolean isManagement() {
        return management;
    }

    public void setManagement(boolean management) {
        this.management = management;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isUnit() {
        return unit;
    }

    public void setUnit(boolean unit) {
        this.unit = unit;
    }

    public boolean isIndicatorType() {
        return indicatorType;
    }

    public void setIndicatorType(boolean indicatorType) {
        this.indicatorType = indicatorType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int[] getGoalTracing() {
        return goalTracing;
    }

    public void setGoalTracing(int[] goalTracing) {
        this.goalTracing = goalTracing;
    }

    public String tracing(){
        String r = "{";
        for(int i=0; i<goalTracing.length; i++)
            r += goalTracing[i] + ",";
        r = r.substring(0, r.length() - 1);
        r += "}";
        return r;
    }

    public int[] getGoalEvaluated() {
        return goalEvaluated;
    }

    public void setGoalEvaluated(int[] goalEvaluated) {
        this.goalEvaluated = goalEvaluated;
    }

    public JSONObject toJson(){
        JSONObject obj = new JSONObject();

        try {
            obj.put("id", getId())
            .put("perspective", getPerspective())
            .put("indicator", getIndicator())
            .put("front", getManagementFront())
            .put("type", getType())
            .put("resp", getResponsibility())
            .put("redaction", getRedaction())
            .put("measure", isMeasure())
            .put("management", isManagement())
            .put("weight", getWeight())
            .put("unit", isUnit())
            .put("typeInd", isIndicatorType())
            .put("goalTracing", tracing());
        }catch (Exception e){
            Log.e("Error", e.toString());
        }
        return obj;
    }

    @Override
    public String toString(){
        return this.toJson().toString();
    }
}
