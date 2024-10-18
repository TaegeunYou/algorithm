package main.java.algolab._study.BubbleSort;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] arr = {9, 6, 3, 1, 2, 4, 5, 7, 8};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
