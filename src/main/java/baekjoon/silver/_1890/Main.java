package main.java.baekjoon.silver._1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long result = execute(n, board);
        System.out.println(result);
    }

    private long execute(int n, int[][] board) {
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == board.length - 1 && j == board[0].length - 1) {
                    break;
                }
                int jump = board[i][j];
                process(i, j, i + jump, j, n, dp);
                process(i, j, i, j + jump, n, dp);
            }
        }
        return dp[n - 1][n - 1];
    }

    private void process(int i, int j, int afterI, int afterJ, int n, long[][] dp) {
        if (afterI < 0 || afterJ < 0 || afterI >= n || afterJ >= n) {
            return;
        }
        dp[afterI][afterJ] += dp[i][j];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
