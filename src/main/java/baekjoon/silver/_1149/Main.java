package main.java.baekjoon.silver._1149;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }
        int result = execute(n, board);
        System.out.println(result);
    }

    private int execute(int n, int[][] board) {
        int[] dpR = new int[n];
        int[] dpG = new int[n];
        int[] dpB = new int[n];
        dpR[0] = board[0][0];
        dpG[0] = board[0][1];
        dpB[0] = board[0][2];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    process(i, j, dpR, dpG, dpB, board);
                } else if (j == 1) {
                    process(i, j, dpG, dpB, dpR, board);
                } else if (j == 2) {
                    process(i, j, dpB, dpR, dpG, board);
                }
            }
        }
        return Math.min(Math.min(dpR[n - 1], dpG[n - 1]), dpB[n - 1]);
    }

    private void process(int i, int j, int[] dp, int[] dp1, int[] dp2, int[][] board) {
        dp[i] = Math.min(dp1[i - 1], dp2[i - 1]) + board[i][j];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
