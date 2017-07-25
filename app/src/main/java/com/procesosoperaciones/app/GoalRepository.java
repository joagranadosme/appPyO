package com.procesosoperaciones.app;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jonathan on 7/15/2017.
 */

public class GoalRepository {

    private static GoalRepository repository;
    private HashMap<String, Goal> goals = new HashMap<>();

    public static GoalRepository getInstance(Context context){
        repository = new GoalRepository();
        try {
            Goal[] loadGoal = FileManager.readGoal(context);
            for(int i=0; i<loadGoal.length; i++)
                repository.saveGoal(loadGoal[i]);
        }catch (Exception e){
            Log.e("GoalRepository", e.toString());
            repository.saveGoal(new Goal());
        }
        return repository;
    }

    public GoalRepository(){}

    private void saveGoal(Goal goal){
        goals.put(goal.getId(), goal);
    }

    public List<Goal> getGoals(){
        return new ArrayList<>(goals.values());
    }

    public List<Goal> add(){
        saveGoal(new Goal());
        return getGoals();
    }

    public List<Goal> delete(Goal goal){
        goals.remove(goal.getId());
        return getGoals();
    }

}
