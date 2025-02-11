package main.java.baekjoon.gold._14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int l = Integer.parseInt(st1.nextToken());
        int[][] board = new int[n][n];
        int[][] board2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
                board2[j][i] = board[i][j];
            }
        }
        int rowCount = execute(n, l, board);
        int colCount = execute(n, l, board2);
        System.out.println(rowCount + colCount);
    }

    private int execute(int n, int l, int[][] board) {
        int count = 0;
        int[][] checkBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            int remain = 0;
            boolean avail = true;
            for (int j = 1; j < n; j++) {
                if (Math.abs(board[i][j] - board[i][j - 1]) > 1) {
                    avail = false;
                    break;
                }
                if (board[i][j] == board[i][j - 1] - 1) {
                    if (remain > 0) {
                        avail = false;
                        break;
                    }
                    checkBoard[i][j] = 1;
                    remain = l - 1;
                    continue;
                }
                if (remain > 0 && board[i][j] == board[i][j - 1]) {
                    checkBoard[i][j] = 1;
                    remain--;
                }
            }
            if (remain > 0) {
                avail = false;
            }
            if (!avail) {
                continue;
            }
            remain = 0;
            avail = true;
            for (int j = n - 2; j >= 0; j--) {
                if (Math.abs(board[i][j] - board[i][j + 1]) > 1) {
                    avail = false;
                    break;
                }
                if (board[i][j] == board[i][j + 1] - 1) {
                    if (remain > 0 || checkBoard[i][j] == 1) {
                        avail = false;
                        break;
                    }
                    checkBoard[i][j] = 1;
                    remain = l - 1;
                    continue;
                }
                if (remain > 0 && board[i][j] == board[i][j + 1]) {
                    if (checkBoard[i][j] == 1) {
                        avail = false;
                        break;
                    }
                    checkBoard[i][j] = 1;
                    remain--;
                }
            }
            if (remain > 0) {
                avail = false;
            }
            if (avail) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
