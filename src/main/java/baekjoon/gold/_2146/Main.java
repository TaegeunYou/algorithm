package main.java.baekjoon.gold._2146;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Map<Integer, List<Node>> map = new HashMap<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    num++;
                    List<Node> nodes = bfsIsland(i, j, num);
                    map.put(num, nodes);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i : map.keySet()) {
            List<Node> nodes = map.get(i);
            int result = bfsOcean(nodes, i);
            answer = Math.min(answer, result);
        }
        System.out.println(answer);
    }

    private int bfsOcean(List<Node> nodes, int num) {
        boolean[][] visited = new boolean[n][n];
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : nodes) {
            queue.offerLast(node);
        }
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (visited[node.x][node.y]) {
                    continue;
                }
                visited[node.x][node.y] = true;
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        continue;
                    }
                    if (board[nx][ny] == num || visited[nx][ny]) {
                        continue;
                    }
                    if (board[nx][ny] != 0) {
                        return count;
                    }
                    queue.offerLast(new Node(nx, ny));
                }
            }
        }
        return 0;
    }

    private List<Node> bfsIsland(int x, int y, int num) {
        List<Node> nodes = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (board[node.x][node.y] == num) {
                continue;
            }
            board[node.x][node.y] = num;
            nodes.add(node);
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    queue.offerLast(new Node(nx, ny));
                }
            }
        }
        return nodes;
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
