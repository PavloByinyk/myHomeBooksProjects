package com.turtledev.pockercounter.objects;

import android.content.Context;

import com.turtledev.pockercounter.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 1 on 26.04.2016.
 */
public class MapCharges {
    Map<Charges, List<Double>> mapCharges;
    private Set<Map.Entry<Charges, List<Double>>> entrySet;

    public Map<Charges, List<Double>> getMapCharges() {
        return mapCharges;
    }

    public void setMapCharges(Map<Charges, List<Double>> mapCharges) {
        this.mapCharges = mapCharges;
    }

    public void setEntrySet(Set<Map.Entry<Charges, List<Double>>> entrySet) {
        this.entrySet = entrySet;
    }

    public Set<Map.Entry<Charges, List<Double>>> getEntrySet() {

        return entrySet;
    }

    public MapCharges(Context context) {
        mapCharges = new LinkedHashMap<Charges, List<Double>>();
        entrySet = mapCharges.entrySet();
        String[] arr = context.getResources().getStringArray(R.array.charges_array);
        List<Double> lst = new ArrayList<Double>();
        double df = 25;
        lst.add(df);


        for (int i = 0; i < arr.length; i++) {
            mapCharges.put(new Charges(arr[i]), lst);


        }

    }
}
