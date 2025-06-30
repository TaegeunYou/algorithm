package main.java.baekjoon.silver._1926;

import java.io.*;
import java.util.*;

public class Main {

    int[][] board;
    boolean[][] visited;
    int countPicture = 0;
    int maxPicture = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        visited = new boolean[n][m];
        execute();
        StringBuilder sb = new StringBuilder();
        sb.append(countPicture).append("\n").append(maxPicture);
        System.out.println(sb);
    }

    private void execute() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (visited[i][j] || board[i][j] == 0) {
                    continue;
                }
                countPicture++;
                bfs(i, j);
            }
        }
    }

    private void bfs(int x, int y) {
        int size = 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y]) {
                continue;
            }
            visited[node.x][node.y] = true;
            size++;
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length  || visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }
                queue.offerLast(new Node(nx, ny));
            }
        }
        maxPicture = Math.max(maxPicture, size);
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
