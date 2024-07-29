package main.java.inflearn.DP;

import java.util.Scanner;

/**
 * 8
 * 5 3 7 8 6 2 9 4
 */
public class Main1003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] dy = new int[n];
        dy[0] = 1;
        int answer = 0;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }

}