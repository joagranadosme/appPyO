package com.procesosoperaciones.app;

import java.util.UUID;

/**
 * Created by Jonathan on 7/13/2017.
 */

public class Goal {

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
    private String unit;
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

    public Goal(String perspective, String strategicGoal, String indicator, String managementFront, String type, String responsibility, String redaction, boolean measure, boolean management, int weight, String unit, boolean indicatorType, String formula, int[] goalTracing) {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
