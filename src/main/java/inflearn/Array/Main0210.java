package main.java.inflearn.Array;

import java.util.Scanner;

/**
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 */
public class Main0210 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n + 2][n + 2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int tmp = arr[i][j];
                if (tmp > arr[i - 1][j]
                    && tmp > arr[i][j - 1]
                    && tmp > arr[i + 1][j]
                    && tmp > arr[i][j + 1]
                ) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

}