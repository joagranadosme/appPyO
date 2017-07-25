package com.procesosoperaciones.app;

import android.content.Context;
import android.os.Environment;
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

    private String fileName = "data.txt";

    public static void fail(Context context, String s){
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    public static void writeGoal(Goal[] goals, Context context) throws IOException{

        File sdcard = Environment.getExternalStorageDirectory();

        if( sdcard == null || !sdcard.isDirectory()) {
            fail(context, "sdcard not available");
        }

        File datadir = new File(sdcard, "com/pyoapp/test/");

        if( !datadir.exists() && !datadir.mkdirs() ) {
            fail(context, "unable to create data directory");
        }
        if( !datadir.isDirectory() ) {
            fail(context, "exists, but is not a directory");
        }

        File data = new File(datadir, "data.txt");
        FileOutputStream fos = new FileOutputStream(data);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeInt(goals.length);

        for(int i=0; i<goals.length; i++)
            os.writeObject(goals[i]);

        os.close();
        fos.close();

    }

    public static Goal[] readGoal(Context context) throws IOException, ClassNotFoundException {

        File sdcard = Environment.getExternalStorageDirectory();
        if( sdcard == null || !sdcard.isDirectory())
            fail(context, "sdcard not available");

        File datadir = new File(sdcard, "com/pyoapp/test/");
        if( !datadir.exists() && !datadir.mkdirs() )
            fail(context, "unable to create data directory");
        if( !datadir.isDirectory() )
            fail(context, "exists, but is not a directory");

        File data = new File(datadir, "data.txt");
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

}
