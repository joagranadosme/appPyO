package com.procesosoperaciones.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jonathan on 7/15/2017.
 */

public class GoalRepository {

    private static GoalRepository repository = new GoalRepository();
    private HashMap<String, Goal> goals = new HashMap<>();

    public static GoalRepository getInstance(){
        return repository;
    }

    private GoalRepository(){
        saveGoal(new Goal());
    }

    private void saveGoal(Goal goal){
        goals.put(goal.getId(), goal);
    }

    public List<Goal> getGoals(){
        return new ArrayList<>(goals.values());
    }

}
