package main.java.baekjoon.gold._2240;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        int answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[t + 1];
        for (int i = 1; i <= t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[][][] dp = new int[t + 1][w + 1][3];
        if (arr[1] == 1) {
            dp[1][w][1] = 1;
            dp[1][w - 1][2] = 0;
        } else {
            dp[1][w][1] = 0;
            dp[1][w - 1][2] = 1;
        }
        for (int i = 2; i <= t; i++) {
            for (int j = w; j >= 0; j--) {
                int a = dp[i - 1][j][1];
                int b = 0;
                if (j + 1 <= w) {
                    b = dp[i - 1][j + 1][2];
                }
                dp[i][j][1] = Math.max(a, b);

                int c = 0;
                if (j + 1 <= w) {
                    c = dp[i - 1][j + 1][1];
                }
                int d = dp[i - 1][j][2];
                dp[i][j][2] = Math.max(c, d);

                if (arr[i] == 1) {
                    dp[i][j][1]++;
                } else {
                    dp[i][j][2]++;
                }
                answer = Math.max(answer, Math.max(dp[i][j][1], dp[i][j][2]));
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
