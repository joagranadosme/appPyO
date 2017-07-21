package com.procesosoperaciones.app;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Jonathan on 7/13/2017.
 */

public class Goal implements Serializable {

    private String id;
    private String perspective;
    private String strategicGoal;
    private String indicator;
    private String managementFront;
    private String type;
    private String responsibility;
    private String redaction;
    private boolean measure;
    private boolean management;
    private int weight;
    private boolean unit;
    private boolean indicatorType;
    private String formula;
    private int[] goalTracing;

    public Goal() {
        this.id = UUID.randomUUID().toString();
        this.perspective = "Nuevo objetivo";
        this.weight = 0;
    }

    public Goal(String perspective, int weight){
        this.id = UUID.randomUUID().toString();
        this.perspective = perspective;
        this.weight = weight;
    }

    public Goal(String perspective, String strategicGoal, String indicator, String managementFront, String type, String responsibility, String redaction, boolean measure, boolean management, int weight, boolean unit, boolean indicatorType, String formula, int[] goalTracing) {
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

    public boolean getUnit() {
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

    public int[] getGoalTracing() {
        return goalTracing;
    }

    public void setGoalTracing(int[] goalTracing) {
        this.goalTracing = goalTracing;
    }

}
