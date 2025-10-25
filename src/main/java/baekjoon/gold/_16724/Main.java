package main.java.baekjoon.gold._16724;

import java.io.*;
import java.util.*;

public class Main {

    int answer = 0;

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        //쭉 방문하다가 이전 단계에서 방문했던 곳이면 -> 방문 처리만 하고 끝내기
        //쭉 방문하다가 이전 단계에서 방문하지 않았지만 현재 단계에서 방문했던 곳이면 (방문 처리 및 safe zone + 1)
        int[][] visited = new int[n][m];
        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] != 0) {
                    continue;
                }
                id++;
                visit(i, j, visited, board, id);
            }
        }
        System.out.println(answer);
    }

    private void visit(int x, int y, int[][] visited, char[][] board, int id) {
        int tmpX = x;
        int tmpY = y;
        while (true) {
            visited[tmpX][tmpY] = id;
            char tmp = board[tmpX][tmpY];
            //이동
            if (tmp == 'U') {
                tmpX += dx[0];
                tmpY += dy[0];
            } else if (tmp == 'R') {
                tmpX += dx[1];
                tmpY += dy[1];
            } else if (tmp == 'D') {
                tmpX += dx[2];
                tmpY += dy[2];
            } else {
                tmpX += dx[3];
                tmpY += dy[3];
            }
            //확인
            if (visited[tmpX][tmpY] == id) {
                answer++;
                return;
            }
            if (visited[tmpX][tmpY] != 0) {
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
