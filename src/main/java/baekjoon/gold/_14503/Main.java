package main.java.baekjoon.gold._14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st2.nextToken());
        int c = Integer.parseInt(st2.nextToken());
        int direction = Integer.parseInt(st2.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st3.nextToken());
            }
        }
        int result = execute(r, c, direction);
        System.out.println(result);
    }
    
    private int execute(int r, int c, int direction) {
        int result = 0;
        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                result++;
            }
            boolean alreadyClean = true;
            for (int i = 0; i < dx.length; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] == 1) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    alreadyClean = false;
                    break;
                }
            }
            if (alreadyClean) {
                int back = (direction + 2) % 4;
                int nx = r + dx[back];
                int ny = c + dy[back];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] == 1) {
                    break;
                }
                r = nx;
                c = ny;
            } else {
                direction = (direction + 3) % 4;
                int nx = r + dx[direction];
                int ny = c + dy[direction];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] == 1) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
