package main.java.inflearn.Two_pointers_Sliding_window;

import java.util.Scanner;

/**
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 */
public class Main0303 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int max = 0, tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += arr[i];
        }
        max = tmp;
        for (int i = k; i < n; i++) {
            tmp = tmp - arr[i - k] + arr[i];
            max = Math.max(tmp, max);
        }
        System.out.println(max);
    }

}