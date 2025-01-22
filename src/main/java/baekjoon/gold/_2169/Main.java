package main.java.baekjoon.gold._2169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int result = execute(board);
        System.out.println(result);
    }

    private int execute(int[][] board) {
        int[][] dp = initialDp(board);
        int[][] leftDp = initialDp(board);
        int[][] rightDp = initialDp(board);
        if (dp.length == 1) {
            return dp[board.length - 1][board[0].length - 1];
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j - 1 < 0) {
                    leftDp[i][j] = dp[i - 1][j] + board[i][j];
                    continue;
                }
                leftDp[i][j] = Math.max(leftDp[i][j - 1], dp[i - 1][j]) + board[i][j];
            }
            for (int j = board[0].length - 1; j >= 0; j--) {
                if (j + 1 >= board[0].length) {
                    rightDp[i][j] = dp[i - 1][j] + board[i][j];
                    continue;
                }
                rightDp[i][j] = Math.max(rightDp[i][j + 1], dp[i - 1][j]) + board[i][j];
            }
            for (int j = 0; j < board[0].length; j++) {
                dp[i][j] = Math.max(leftDp[i][j], rightDp[i][j]);
            }
        }
        return dp[board.length - 1][board[0].length - 1];
    }

    private int[][] initialDp(int[][] board) {
        int[][] dp = new int[board.length][board[0].length];
        dp[0][0] = board[0][0];
        for (int i = 1; i < board[0].length; i++) {
            dp[0][i] = board[0][i] + dp[0][i - 1];
        }
        return dp;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
