package main.java.baekjoon.silver._14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Node start = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
                if (arr[i][j] == 2) {
                    start = new Node(i, j);
                }
            }
        }
        int[][] result = bfs(n, m, arr, start);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int[][] bfs(int n, int m, int[][] arr, Node start) {
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(start);
        visited[start.x][start.y] = true;
        int dist = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node poll = queue.pollFirst();
                for (int j = 0; j < dx.length; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == 1) {
                        queue.offerLast(new Node(nx, ny));
                        visited[nx][ny] = true;
                        result[nx][ny] = dist;
                    }
                }
            }
            dist++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (result[i][j] == 0) {
                    result[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 || arr[i][j] == 2) {
                    result[i][j] = 0;
                }
            }
        }
        return result;
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
