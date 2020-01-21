package com.example.tulips.sample;

import com.example.tulips.R;
import com.example.tulips.model.Bulb;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    public static List<Bulb> tulipList;

    static {
        tulipList = new ArrayList<>();
        addItem(new Bulb("Daydream", R.drawable.daydream));
        addItem(new Bulb("Apeldoorn Elite", R.drawable.apeldoorn));
        addItem(new Bulb("Banja Luka", R.drawable.banjaluka));
        addItem(new Bulb("Burning Heart", R.drawable.burningheart));
        addItem(new Bulb("Cape Cod", R.drawable.capecod));
    }

    private static void addItem(Bulb item){
        tulipList.add(item);
    }
}
