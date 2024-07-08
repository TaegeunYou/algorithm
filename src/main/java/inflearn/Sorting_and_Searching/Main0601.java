package main.java.inflearn.Sorting_and_Searching;

import java.util.*;

/**
 * 6
 * 13 5 11 7 23 15
 */
public class Main0601 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int iNum = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = iNum;
        }
        System.out.println(Arrays.toString(arr));
    }

}