package main.java.baekjoon.gold._2573;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        int result = execute();
        System.out.println(result);
    }

    private int execute() {
        boolean flag = true;
        int time = -1;
        while (flag) {
            flag = false;
            time++;
            boolean[][] visited = new boolean[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != 0 && !visited[i][j]) {
                        flag = true;
                        count++;
                        bfs(i, j, visited);
                    }
                }
            }
            if (count > 1) {
                return time;
            }
        }
        return 0;
    }

    private void bfs(int x, int y, boolean[][] visited) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        List<Decrease> decreases = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Node node = queue.pollFirst();
                if (visited[node.x][node.y] || board[node.x][node.y] == 0) {
                    continue;
                }
                visited[node.x][node.y] = true;
                int decrease = 0;
                for (int i = 0; i < dx.length; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (board[nx][ny] == 0) {
                        decrease++;
                        continue;
                    }
                    if (!visited[nx][ny]) {
                        queue.offerLast(new Node(nx, ny));
                    }
                }
                if (decrease > 0) {
                    decreases.add(new Decrease(node.x, node.y, decrease));
                }
            }
        }
        for (Decrease decrease : decreases) {
            board[decrease.x][decrease.y] = Math.max(0, board[decrease.x][decrease.y] - decrease.count);
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

    private class Decrease {
        int x;
        int y;
        int count;
        public Decrease(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
