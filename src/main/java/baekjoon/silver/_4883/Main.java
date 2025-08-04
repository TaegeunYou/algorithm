package main.java.baekjoon.silver._4883;

import java.io.*;
import java.util.*;

public class Main {

    StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            process(n, num++, br);
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void process(int n, int num, BufferedReader br) throws IOException {
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][3];
        dp[0][0] = 1000000;
        dp[0][1] = board[0][1];
        dp[0][2] = dp[0][1] + board[0][2];
        for (int i = 1; i < n; i++) {
            int a = dp[i - 1][0];
            int b = dp[i - 1][1];
            int c = dp[i - 1][2];
            dp[i][0] = Math.min(a, b) + board[i][0];
            dp[i][1] = Math.min(Math.min(Math.min(a, b), c), dp[i][0]) + board[i][1];
            dp[i][2] = Math.min(Math.min(b, c), dp[i][1]) + board[i][2];
        }
        sb.append(num + ". " + dp[n - 1][1]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
