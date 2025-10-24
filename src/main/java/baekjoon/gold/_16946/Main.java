package main.java.baekjoon.gold._16946;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    int[][] board;
    Map<Integer, Integer> map = new HashMap<>();
    boolean[][] visited;
    int id = 1;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0 || visited[i][j]) {
                    continue;
                }
                id++;
                bfs(i, j);
            }
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 1) {
                    continue;
                }
                Set<Integer> ids = new HashSet<>();
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 1) {
                        continue;
                    }
                    ids.add(board[nx][ny]);
                }
                int total = 1;
                for (int id : ids) {
                    total += map.get(id);
                }
                result[i][j] = total % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void bfs(int x, int y) {
        int count = 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y]) {
                continue;
            }
            count++;
            board[node.x][node.y] = id;
            visited[node.x][node.y] = true;
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || board[nx][ny] != 0) {
                    continue;
                }
                queue.offerLast(new Node(nx, ny));
            }
        }
        map.put(id, count);
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
