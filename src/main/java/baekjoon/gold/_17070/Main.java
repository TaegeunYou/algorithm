package main.java.baekjoon.gold._17070;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int[][] board;
    Deque<Node> queue = new ArrayDeque<>();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        queue.offerLast(new Node(1, 2, 1));
        int answer = 0;
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            System.out.println(node.x + " " + node.y);
            if (node.x == n && node.y == n) {
                answer++;
                continue;
            }
            if (node.status == 1) {
                process(node.x, node.y + 1, 1);
                process(node.x + 1, node.y + 1, 3);
            } else if (node.status == 2) {
                process(node.x + 1, node.y, 2);
                process(node.x + 1, node.y + 1, 3);
            } else {
                process(node.x, node.y + 1, 1);
                process(node.x + 1, node.y, 2);
                process(node.x + 1, node.y + 1, 3);
            }
        }
        System.out.println(answer);
    }

    private void process(int x, int y, int status) {
        //가능하면 큐에 추가
        //벽 x, 밖 x
        if (unavail(x, y)) {
            return;
        }
        if (status == 1) {
            if (unavail(x, y - 1)) {
                return;
            }
        } else if (status == 2) {
            if (unavail(x - 1, y)) {
                return;
            }
        } else {
            if (unavail(x - 1, y) || unavail(x, y - 1)) {
                return;
            }
        }
        queue.offerLast(new Node(x, y, status));
    }

    private boolean unavail(int r, int c) {
        if (r < 1 || c < 1 || r > n || c > n) {
            return true;
        }
        if (board[r][c] == 1) {
            return true;
        }
        return false;
    }

    private class Node {
        //오른쪽이나 아래이나 파이프 기준
        int x;
        int y;
        //상태: 1-가로, 2-세로, 3-대각선
        int status;
        public Node(int x, int y, int status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
