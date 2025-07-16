package main.java.baekjoon.gold._14442;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    int k;
    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        int result = execute();
        System.out.println(result);
    }

    private int execute() {
        boolean[][][] visited = new boolean[n][m][k + 1];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, 0, 1, k));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y][node.k]) {
                continue;
            }
            visited[node.x][node.y][node.k] = true;
            if (node.x == n - 1 && node.y == m - 1) {
                return node.count;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    if (node.k == 0 || visited[nx][ny][node.k - 1]) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny, node.count + 1, node.k - 1));
                } else {
                    if (visited[nx][ny][node.k]) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny, node.count + 1, node.k));
                }
            }
        }
        return -1;
    }

    private class Node {
        int x;
        int y;
        int count;
        int k;

        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
