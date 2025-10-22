package main.java.baekjoon.gold._3628;

import java.io.*;
import java.util.*;

public class Main {

    int[][] board;
    int n;
    int m;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 흰색으로만 bfs하면서 외부 격자로 하나라도 나가면 외부 공기, 외부 격자로 하나도 안나가면 내부 공기
        // 0. 매 턴마다
        // 1. 모든 흰색 애들에 대해서 외부 공기인지 아닌지 명시 (1보다 작은거, 외부 공기는 -1, 내부 공기는 0)
        // 2. C로 표시될 치즈 삭제 (-1 공기를 2개 이상 닿아있는것)
        // 3. 치즈가 남지 않았으면 종료
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }
        int answer = 0;
        while (!isFinish()) {
            answer++;
            checkOutAir();
            removeC();
        }
        System.out.println(answer);
    }

    private void checkOutAir() {
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || board[i][j] != 0) {
                    continue;
                }
                bfs(i, j, visited);
            }
        }
    }

    private void bfs(int x, int y, boolean[][] visited) {
        List<Node> nodes = new ArrayList<>();
        boolean isOutAir = false;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y]) {
                continue;
            }
            visited[node.x][node.y] = true;
            nodes.add(node);
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    isOutAir = true;
                    continue;
                }
                if (visited[nx][ny] || board[nx][ny] != 0) {
                    continue;
                }
                queue.offerLast(new Node(nx, ny));
            }
        }
        if (isOutAir) {
            for (Node node : nodes) {
                board[node.x][node.y] = -1;
            }
        }
    }

    private boolean isFinish() {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    flag = false;
                }
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
        return flag;
    }

    private void removeC() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 1) {
                    continue;
                }
                int count = 0;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (board[nx][ny] == -1) {
                        count++;
                    }
                }
                if (count >= 2) {
                    board[i][j] = 0;
                }
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
