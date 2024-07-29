package main.java.inflearn.DP;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3
 * 1 2 5
 * 15
 */
public class Main1005 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int cost : costs) {
            for (int j = cost; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - cost] + 1);
            }
        }
        System.out.println(dy[m]);
    }

}