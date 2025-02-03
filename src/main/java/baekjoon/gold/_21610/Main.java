package main.java.baekjoon.gold._21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    int n;
    int m;
    int[][] board;
    List<Node> nodes = new ArrayList<>();
    int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        nodes.add(new Node(n - 1, 0));
        nodes.add(new Node(n - 1, 1));
        nodes.add(new Node(n - 2, 0));
        nodes.add(new Node(n - 2, 1));
        for (int i = 0; i < m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st3.nextToken());
            int s = Integer.parseInt(st3.nextToken());
            execute(d, s);
        }
        int result = calculate();
        System.out.println(result);
    }

    private void execute(int d, int s) {
        int totalDx = dx[d - 1] * s;
        int totalDy = dy[d - 1] * s;
        for (Node node : nodes) {
            int nx = (n * 25 + node.x + totalDx) % n;
            int ny = (n * 25 + node.y + totalDy) % n;
            board[nx][ny]++;
            node.x = nx;
            node.y = ny;
        }
        for (Node node : nodes) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                int idx = i * 2 + 1;
                int nx = node.x + dx[idx];
                int ny = node.y + dy[idx];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (board[nx][ny] >= 1) {
                    count++;
                }
            }
            node.tmp = count;
        }
        for (Node node : nodes) {
            board[node.x][node.y] += node.tmp;
        }
        List<Node> newNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < 2) {
                    continue;
                }
                boolean flag = true;
                for (Node node : nodes) {
                    if (node.x == i && node.y == j) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    board[i][j] -= 2;
                    newNodes.add(new Node(i, j));
                }
            }
        }
        nodes = newNodes;
    }

    private int calculate() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += board[i][j];
            }
        }
        return result;
    }

    private class Node {
        int x;
        int y;
        int tmp;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
