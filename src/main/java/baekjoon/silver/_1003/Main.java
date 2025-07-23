package main.java.baekjoon.silver._1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 40;
        int[][] board = new int[max + 1][2];
        board[0][0] = 1;
        board[0][1] = 0;
        board[1][0] = 0;
        board[1][1] = 1;
        for (int i = 2; i <= max; i++) {
            board[i][0] = board[i - 1][0] + board[i - 2][0];
            board[i][1] = board[i - 1][1] + board[i - 2][1];
        }
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String result = board[n][0] + " " + board[n][1];
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
