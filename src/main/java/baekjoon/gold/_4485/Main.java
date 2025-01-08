package main.java.baekjoon.gold._4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int seq = 0;
        while (true) {
            seq++;
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = execute(n, arr);
            sb.append(String.format("Problem %s: ", seq)).append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int execute(int n, int[][] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        int[][] result = new int[n][n];
        pq.add(new Node(0, 0, arr[0][0]));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.x][node.y]) {
                continue;
            }
            visited[node.x][node.y] = true;
            result[node.x][node.y] = node.cost;
            if (node.x == n - 1 && node.y == n - 1) {
                break;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new Node(nx, ny, node.cost + arr[nx][ny]));
                }
            }
        }
        return result[n - 1][n - 1];
    }

    private class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
