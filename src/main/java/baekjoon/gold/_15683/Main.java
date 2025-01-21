package main.java.baekjoon.gold._15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private char[][] board;
    private List<Cctv> cctvs = new ArrayList<>();

    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    private int answer = Integer.MAX_VALUE;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = st2.nextToken().charAt(0);
                if (board[i][j] != '0' && board[i][j] != '5' && board[i][j] != '6') {
                    cctvs.add(new Cctv(i, j, board[i][j]));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '5') {
                    for (int k = 0; k < dx.length; k++) {
                        change(dx[k], dy[k], new Cctv(i, j, '5'), true, 10);
                    }
                }
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private void dfs(int idx) {
        if (idx == cctvs.size()) {
            int count = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '0') {
                        count++;
                    }
                }
            }
            answer = Math.min(answer, count);
            return;
        }
        Cctv cctv = cctvs.get(idx);
        if (cctv.type == '1') {
            for (int i = 0; i < dx.length; i++) {
                change(dx[i], dy[i], cctv, true, idx);
                dfs(idx + 1);
                change(dx[i], dy[i], cctv, false, idx);
            }
        } else if (cctv.type == '2') {
            for (int i = 0; i < dx.length / 2; i++) {
                change(dx[i], dy[i], cctv, true, idx);
                change(dx[i + 2], dy[i + 2], cctv, true, idx);
                dfs(idx + 1);
                change(dx[i], dy[i], cctv, false, idx);
                change(dx[i + 2], dy[i + 2], cctv, false, idx);
            }
        } else if (cctv.type == '3') {
            for (int i = 0; i < dx.length; i++) {
                change(dx[i], dy[i], cctv, true, idx);
                change(dx[(i + 1) % 4], dy[(i + 1) % 4], cctv, true, idx);
                dfs(idx + 1);
                change(dx[i], dy[i], cctv, false, idx);
                change(dx[(i + 1) % 4], dy[(i + 1) % 4], cctv, false, idx);
            }
        } else if (cctv.type == '4') {
            for (int i = 0; i < dx.length; i++) {
                change(dx[i], dy[i], cctv, true, idx);
                change(dx[(i + 1) % 4], dy[(i + 1) % 4], cctv, true, idx);
                change(dx[(i + 2) % 4], dy[(i + 2) % 4], cctv, true, idx);
                dfs(idx + 1);
                change(dx[i], dy[i], cctv, false, idx);
                change(dx[(i + 1) % 4], dy[(i + 1) % 4], cctv, false, idx);
                change(dx[(i + 2) % 4], dy[(i + 2) % 4], cctv, false, idx);
            }
        }
    }

    private void change(int dx, int dy, Cctv cctv, boolean check, int idx) {
        int x = cctv.x;
        int y = cctv.y;
        char tmp = (char) (65 + idx);
        while (x >= 0 && y >= 0 && x < board.length && y < board[0].length) {
            if (board[x][y] == '6') {
                break;
            }
            if (check && board[x][y] == '0') {
                board[x][y] = tmp;
            } else if (!check && board[x][y] == tmp) {
                board[x][y] = '0';
            }
            x += dx;
            y += dy;
        }
    }

    private class Cctv {
        int x;
        int y;
        char type;

        public Cctv(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}