package main.java.algolab._study.SelectionSort;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = {9, 6, 3, 1, 2, 4, 5, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            if (i == minIdx) {
                continue;
            }
            int tmp = arr[i];
            arr[i] = min;
            arr[minIdx] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
