package com.example.myretrofit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int res = 0;

        int array[] = list.stream().mapToInt(i->i).toArray();
        heapSort(array);

        res += array[array.length-1] + array[array.length-2];

        return res;
    }

    public static void heapify(int array[], int n, int i) {
        int p = i;
        int l = i * 2 + 1;
        int r = i * 2 + 2;

        if (l < n && array[p] < array[l]) {
            p = l;
        }

        if (r < n && array[p] < array[r]) {
            p = r;
        }

        if (i != p) {
            swap(array, p, i);
            heapify(array, n, p);
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // init, max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // for extract max element from heap
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
