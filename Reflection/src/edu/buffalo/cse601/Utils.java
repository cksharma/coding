package edu.buffalo.cse601;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cksharma on 12/4/15.
 */
public final class Utils {

    public static Map<Integer, Map<String, Double>> valueMap = new HashMap<>();

    public static Map<Integer, Map<Double, String>> valueReverseMap = new HashMap<>();

    public static List<Sample> getFeatureList(String filePath) {
        List<Sample> featureListAll = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() == 0) continue;
                String[] featureArr = line.split("\\s+");
                List<Feature> fList = new ArrayList<>();
                String featureClass = featureArr[featureArr.length - 1];
                for (int i = 0; i < featureArr.length - 1; i++) {
                    int featureId = i;
                    FeatureType type = getFeatureType(featureArr[i]);
                    double value = getDoubleValueForFeature(i, featureArr[i]);
                    fList.add(new Feature(featureId, featureClass, type, value));
                }
                Sample sample = new Sample(featureClass, fList);
                featureListAll.add(sample);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return featureListAll;
    }

    private static double getDoubleValueForFeature(int featureId, String value) {
        Map<String, Double> map = valueMap.get(featureId);
        if (map == null) {
            map = new HashMap<>();
            map.put(value, map.size()*1.);
        } else {
            if (map.containsKey(value)) {
                return map.get(value);
            }
            map.put(value, map.size()*1.);
        }

        valueMap.put(featureId, map);
        populateReverseMap(featureId, value);
        return map.get(value);
    }

    private static void populateReverseMap(int featureId, String value) {
        Map<Double, String> map = valueReverseMap.get(featureId);
        if (map == null) map = new HashMap<>();
        map.put(valueMap.get(featureId).get(value), value);
        valueReverseMap.put(featureId, map);
    }

    private static FeatureType getFeatureType(String value) {
        return FeatureType.DISCRETE;
    }

    public static int sumOfTotalAttribute(Map<String, Integer> map) {
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        return sum;
    }

    public static double log2(double value) {
        return Math.log(value) / Math.log(2);
    }

    private Utils() {

    }
}
