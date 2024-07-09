package main.java.inflearn.Sorting_and_Searching;

import java.util.Scanner;

/**
 * 9
 * 120 125 152 130 135 135 143 127 160
 */
public class Main0606 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 2];
        arr[n + 1] = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            arr[i] = in.nextInt();
        }
        int lt = -1;
        int rt = -1;
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                lt = i;
            } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1] && rt == -1) {
                rt = i;
            }
        }
        System.out.println(rt + " " + lt);
    }

}