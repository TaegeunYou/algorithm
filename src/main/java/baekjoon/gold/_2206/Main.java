package main.java.baekjoon.gold._2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        int result = execute(n, m, board);
        System.out.println(result);
    }

    private int execute(int n, int m, int[][] board) {
        boolean[][] visited = new boolean[n][m];
        boolean[][] breakVisited = new boolean[n][m];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, 0, false));
        int seq = 0;
        while (!queue.isEmpty()) {
            seq++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (node.breakFlag) {
                    if (breakVisited[node.x][node.y]) {
                        continue;
                    }
                    breakVisited[node.x][node.y] = true;
                } else {
                    if (visited[node.x][node.y]) {
                        continue;
                    }
                    visited[node.x][node.y] = true;
                }
                if (node.x == n - 1 && node.y == m - 1) {
                    return seq;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (!visited[nx][ny] && board[nx][ny] == 0) {
                        queue.offerLast(new Node(nx, ny, node.breakFlag));
                    }
                    if (!node.breakFlag && board[nx][ny] == 1) {
                        queue.offerLast(new Node(nx, ny, true));
                    }
                }
            }
        }
        return -1;
    }

    private class Node {
        int x;
        int y;
        boolean breakFlag;

        public Node(int x, int y, boolean breakFlag) {
            this.x = x;
            this.y = y;
            this.breakFlag = breakFlag;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
