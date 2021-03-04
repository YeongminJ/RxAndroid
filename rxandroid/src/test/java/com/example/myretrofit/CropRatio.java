package com.example.myretrofit;

import org.junit.Test;

import java.util.HashMap;

public class CropRatio {
    private float totalWeight;
    private HashMap<String, Integer> crops = new HashMap<String, Integer>();

    public void add(String name, int cropWeight) {
        Integer currentCropWeight = crops.get(name);

        if (currentCropWeight == null) {
            crops.put(name, cropWeight);
        }
        else {
            crops.put(name, currentCropWeight + cropWeight);
        }
        totalWeight += cropWeight;
    }

    public double proportion(String name) {
        if (crops == null) return 0;
        if (name == null) return 0;
        if (crops.get(name) == 0) return 0;
        return crops.get(name) / totalWeight;
    }

    public static void main(String[] args) {
        CropRatio cropRatio = new CropRatio();

        cropRatio.add("Wheat", 4);
        cropRatio.add("Wheat", 5);
        cropRatio.add("Rice", 1);

        System.out.println("!!!Fraction of wheat: " + cropRatio.totalWeight + ", " + cropRatio.crops.get("Wheat"));
        System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
    }
}