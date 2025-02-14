package main.java.baekjoon.silver._9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = execute2(n, board);
            sb.append(answer).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

    private int execute2(int n, int[][] board) {
        int[][] dp = new int[2][n];
        dp[0][0] = board[0][0];
        dp[1][0] = board[1][0];
        if (n >= 2) {
            dp[0][1] = board[1][0] + board[0][1];
            dp[1][1] = board[0][0] + board[1][1];
        }
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + board[0][i];
            dp[1][i] = Math.max(dp[0][i - 2], dp[0][i - 1]) + board[1][i];
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
