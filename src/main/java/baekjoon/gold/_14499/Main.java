package main.java.baekjoon.gold._14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int x;
    int y;
    int[][] board;
    int[] dice = new int[6];
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        x = Integer.parseInt(st1.nextToken());
        y = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st3.nextToken());
            Integer result = execute(command);
            if (result != null) {
                sb.append(result).append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    
    private Integer execute(int command) {
        int nx = x + dx[command - 1];
        int ny = y + dy[command - 1];
        if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
            return null;
        }
        x = nx;
        y = ny;
        int a2 = dice[0];
        int a1 = dice[1];
        int a5 = dice[2];
        int a6 = dice[3];
        int a4 = dice[4];
        int a3 = dice[5];
        if (command == 1) {
            dice[0] = a2;
            dice[1] = a3;
            dice[2] = a5;
            dice[3] = a4;
            dice[4] = a1;
            dice[5] = a6;
        } else if (command == 2) {
            dice[0] = a2;
            dice[1] = a4;
            dice[2] = a5;
            dice[3] = a3;
            dice[4] = a6;
            dice[5] = a1;
        } else if (command == 3) {
            dice[0] = a1;
            dice[1] = a5;
            dice[2] = a6;
            dice[3] = a2;
            dice[4] = a4;
            dice[5] = a3;
        } else {
            dice[0] = a6;
            dice[1] = a2;
            dice[2] = a1;
            dice[3] = a5;
            dice[4] = a4;
            dice[5] = a3;
        }
        if (board[x][y] == 0) {
            board[x][y] = dice[1];
        } else {
            dice[1] = board[x][y];
            board[x][y] = 0;
        }
        return dice[3];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
