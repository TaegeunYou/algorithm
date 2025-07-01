package main.java.baekjoon.gold._7569;

import java.io.*;
import java.util.*;

public class Main {

    int m;
    int n;
    int h;
    int[][][] board;
    Deque<Node> queue;
    int[] dx = {-1, 0, 1, 0, 0, 0};
    int[] dy = {0, 1, 0, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, 1, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());
        n = Integer.parseInt(st1.nextToken());
        h = Integer.parseInt(st1.nextToken());
        board = new int[h][n][m];
        queue = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(st2.nextToken());
                    if (board[i][j][k] == 1) {
                        board[i][j][k] = 0;
                        queue.offerLast(new Node(j, k, i));
                    }
                }
            }
        }
        int result = execute();
        if (check()) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private boolean check() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private int execute() {
        int day = -1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            boolean isChange = false;
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (board[node.z][node.x][node.y] != 0) {
                    continue;
                }
                board[node.z][node.x][node.y] = 1;
                isChange = true;
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    int nz = node.z + dz[j];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h){
                        continue;
                    }
                    if (board[nz][nx][ny] != 0) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny, nz));
                }
            }
            if (isChange) {
                day++;
            }
        }
        return day;
    }

    private class Node {
        int x;
        int y;
        int z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
