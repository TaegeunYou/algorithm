package main.java.algolab._study.InsertionSort;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = {9, 6, 3, 1, 2, 4, 5, 7, 8};
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                    continue;
                }
                break;
            }
            arr[j + 1] = value;
        }
        System.out.println(Arrays.toString(arr));
    }
}
