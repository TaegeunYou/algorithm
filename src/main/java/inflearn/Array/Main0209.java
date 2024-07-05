package main.java.inflearn.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 */
public class Main0209 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> sums = new ArrayList<>();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        //가로, 세로합
        for (int i = 0; i < n; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            sums.add(sum1);
            sums.add(sum2);
        }
        //대각선합
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1];
        }
        sums.add(sum1);
        sums.add(sum2);
        System.out.println(Collections.max(sums));
    }

}