package main.java.baekjoon.gold._16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        int result = execute(n, m, k, board);
        sb.append(result);
        System.out.println(sb);
    }

    private int execute(int n, int m, int k, int[][] board) {
        boolean[][][][] visited = new boolean[n][m][k + 1][2];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, k, 1, 1));
        visited[0][0][k][1] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.time;
            }
            for (int j = 0; j < dx.length; j++) {
                int nx = node.x + dx[j];
                int ny = node.y + dy[j];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    if (node.isAfternoon == 1 && node.remainK > 0 && !visited[nx][ny][node.remainK - 1][0]) {
                        queue.offer(new Node(nx, ny, node.remainK - 1, 0, node.time + 1));
                        visited[nx][ny][node.remainK - 1][0] = true;
                    } else if (node.isAfternoon == 0 && node.remainK > 0 && !visited[node.x][node.y][node.remainK][1]) {
                        queue.offer(new Node(node.x, node.y, node.remainK, 1, node.time + 1));
                        visited[node.x][node.y][node.remainK][1] = true;
                    }
                } else {
                    if (!visited[nx][ny][node.remainK][(node.isAfternoon + 1) % 2]) {
                        queue.offer(new Node(nx, ny, node.remainK, (node.isAfternoon + 1) % 2, node.time + 1));
                        visited[nx][ny][node.remainK][(node.isAfternoon + 1) % 2] = true;
                    }
                }
            }
        }
        return -1;
    }

    private class Node {
        int x;
        int y;
        int remainK;
        int isAfternoon;
        int time;
        public Node(int x, int y, int remainK, int isAfternoon, int time) {
            this.x = x;
            this.y = y;
            this.remainK = remainK;
            this.isAfternoon = isAfternoon;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
