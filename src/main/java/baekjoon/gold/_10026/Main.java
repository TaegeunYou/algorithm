package main.java.baekjoon.gold._10026;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    char[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int result1 = execute();
        update();
        int result2 = execute();
        System.out.println(result1 + " " + result2);
    }

    private void update() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'G') {
                    board[i][j] = 'R';
                }
            }
        }
    }

    private int execute() {
        int result = 0;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, visited);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(int x, int y, boolean[][] visited) {
        char color = board[x][y];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y]) {
                continue;
            }
            visited[node.x][node.y] = true;
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || board[nx][ny] != color) {
                    continue;
                }
                queue.offerLast(new Node(nx, ny));
            }
        }
    }

    private class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
