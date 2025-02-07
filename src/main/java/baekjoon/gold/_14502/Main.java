package main.java.baekjoon.gold._14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int n;
    int m;
    int[][] board;
    int answer = 0;
    List<Node> virus = new ArrayList<>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int emptyRoomCount = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
                if (board[i][j] == 2) {
                    virus.add(new Node(i, j));
                    emptyRoomCount++;
                } else if (board[i][j] == 0) {
                    emptyRoomCount++;
                }
            }
        }
        emptyRoomCount -= 3;
        recursion(0);
        answer = Math.max(answer, 0);
        System.out.println(answer);
    }

    private void recursion(int count) {
        if (count == 3) {
            int result = check();
            answer = Math.max(answer, result);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    recursion(count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    private int check() {
        Deque<Node> queue = new ArrayDeque<>(virus);
        boolean[][] visited = new boolean[n][m];
        int virusCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                if (visited[node.x][node.y]) {
                    continue;
                }
                visited[node.x][node.y] = true;
                virusCount++;
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] != 0 || visited[nx][ny]) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny));
                }
            }
        }
        return emptyRoomCount - virusCount;
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
