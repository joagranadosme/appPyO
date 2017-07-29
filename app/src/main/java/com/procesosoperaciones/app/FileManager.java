package com.procesosoperaciones.app;

import android.content.Context;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Jonathan on 7/25/2017.
 */

public class FileManager {

    private static final String APP_PATH_SD_CARD = "/com.pyoapp/data/";
    private static final String fileGoals = "goals.txt";
    private static final String fileBoss = "boss.txt";

    public static void fail(Context context, String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    public static void writeGoal(Goal[] goals, Context context) throws IOException{

        String fullPath = context.getFilesDir() + APP_PATH_SD_CARD;
        File dir = new File(fullPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File data = new File(dir + File.separator + fileGoals);
        data.createNewFile();
        FileOutputStream fos = new FileOutputStream(data);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeInt(goals.length);

        for(int i=0; i<goals.length; i++)
            os.writeObject(goals[i]);

        os.close();
        fos.close();

    }

    public static void writeBoss(Boss boss, Context context) throws IOException{

        String fullPath = context.getFilesDir() + APP_PATH_SD_CARD;
        File dir = new File(fullPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File data = new File(dir + File.separator + fileBoss);
        data.createNewFile();

        FileOutputStream fos = new FileOutputStream(data);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(boss);

        os.close();
        fos.close();

        fail(context, dir.toString());

    }

    public static Goal[] readGoal(Context context) throws IOException, ClassNotFoundException {

        String fullPath = context.getFilesDir() + APP_PATH_SD_CARD;
        File dir = new File(fullPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File data = new File(dir + File.separator + fileGoals);
        data.createNewFile();

        FileInputStream fis = new FileInputStream(data);
        ObjectInputStream is = new ObjectInputStream(fis);

        int n = is.readInt();
        Goal[]  goals = new Goal[n];

        for(int i=0; i<n; i++)
            goals[i] = (Goal) is.readObject();

        is.close();
        fis.close();

        return goals;

    }

    public static Boss readBoss(Context context) throws  IOException, ClassNotFoundException {

        String fullPath = context.getFilesDir() + APP_PATH_SD_CARD;
        File dir = new File(fullPath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        File data = new File(dir + File.separator + fileBoss);
        data.createNewFile();

        FileInputStream fis = new FileInputStream(data);
        ObjectInputStream is = new ObjectInputStream(fis);

        Boss boss = (Boss) is.readObject();

        is.close();
        fis.close();

        return boss;

    }

}
