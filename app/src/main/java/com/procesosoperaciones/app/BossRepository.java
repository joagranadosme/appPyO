package com.procesosoperaciones.app;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Jonathan on 7/13/2017.
 */

public class BossRepository {

    private static BossRepository repository;
    private HashMap<String, Boss> bosses = new HashMap<>();

    public static BossRepository getInstance(){
        return new BossRepository();
    }

    private BossRepository(){
        saveBoss(new Boss("Alexander Pierrot", "CEO", "Insures S.O.", R.drawable.lead_photo_1));
        saveBoss(new Boss("Carlos Lopez", "Asistente", "Hospital Blue", R.drawable.lead_photo_2));
        saveBoss(new Boss("Sara Bonz", "Directora de Marketing", "Electrical Parts ltd", R.drawable.lead_photo_3));
        saveBoss(new Boss("Liliana Clarence", "Diseñadora de Producto", "Creativa App", R.drawable.lead_photo_4));
        saveBoss(new Boss("Benito Peralta", "Supervisor de Ventas", "Neumáticos Press", R.drawable.lead_photo_5));
        saveBoss(new Boss("Juan Jaramillo", "CEO", "Banco Nacional", R.drawable.lead_photo_6));
        saveBoss(new Boss("Christian Steps", "CTO", "Cooperativa Verde", R.drawable.lead_photo_7));
        saveBoss(new Boss("Alexa Giraldo", "Boss Programmer", "Frutisofy", R.drawable.lead_photo_8));
        saveBoss(new Boss("Linda Murillo", "Directora de Marketing", "Seguros Boliver", R.drawable.lead_photo_9));
        saveBoss(new Boss("Lizeth Astrada", "CEO", "Concesionario Motolox", R.drawable.lead_photo_10));
    }

    private void saveBoss(Boss boss){
        bosses.put(boss.getId(), boss);
    }

    public List<Boss> getBosses(){
        return new ArrayList<>(bosses.values());
    }

    public static Boss getBoss(Context context){
        Boss boss = null;
        try{
            boss = FileManager.readBoss(context);
        }catch (Exception e){
            Log.e("BossRepository", e.toString());
        }
        return boss;
    }

}
