package com.example.myretrofit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BookSale {
    public static int nthLowestSelling(int[] sales, int n) {
        int res = 0;

        HashMap<Integer, Integer> salesMap = new HashMap<>();
        //counting
        for (int item : sales) {
            if (salesMap.get(item) == null || salesMap.get(item) == 0) {
                salesMap.put(item, 1);
            }
            else {
                salesMap.put(item, salesMap.get(item)+1);
            }
        }
        List<Integer> keySetList = new ArrayList<>(salesMap.keySet());

        // sort
        Collections.sort(keySetList, (o1, o2) -> (salesMap.get(o1).compareTo(salesMap.get(o2))));

        System.out.println("VV : " + salesMap.get(keySetList.get(n-1)));
        return keySetList.get(n-1);
    }
}
