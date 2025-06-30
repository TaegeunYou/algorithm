package main.java.baekjoon.gold._7576;

import java.io.*;
import java.util.*;

public class Main {

    int[][] board;
    int m;
    int n;
    Deque<Node> queue;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st1.nextToken());
        n = Integer.parseInt(st1.nextToken());
        board = new int[n][m];
        queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
                if (board[i][j] == 1) {
                    queue.offerLast(new Node(i, j, true));
                }
            }
        }
        int day = -1;
        while (!queue.isEmpty()) {
            day++;
            boolean result = execute();
            if (!result) {
                day--;
            }
        }
        if (check()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    private boolean execute() {
        int len = queue.size();
        boolean result = false;
        for (int i = 0; i < len; i++) {
            Node node = queue.pollFirst();
            if (!node.isStart && board[node.x][node.y] == 1) {
                continue;
            }
            board[node.x][node.y] = 1;
            result = true;
            for (int j = 0; j < dx.length; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    queue.offerLast(new Node(nx, ny, false));
                }
            }
        }
        return result;
    }

    private boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private class Node {
        int x;
        int y;
        boolean isStart;
        public Node(int x, int y, boolean isStart) {
            this.x = x;
            this.y = y;
            this.isStart = isStart;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
