package main.java.baekjoon.gold._15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int endX = x + dx[d];
            int endY = y + dy[d];
            List<Node> nodes = new ArrayList<>();
            nodes.add(new Node(x, y));
            nodes.add(new Node(endX, endY));
            for (int j = 0; j < g; j++) {
                execute(nodes);
            }
            list.add(nodes);
        }
        boolean[][] board = new boolean[101][101];
        for (List<Node> nodes : list) {
            for (Node node : nodes) {
                board[node.x][node.y] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (i + 1 > 100 || j + 1 > 100) {
                    continue;
                }
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private void execute(List<Node> nodes) {
        int len = nodes.size();
        Node standardNode = nodes.get(nodes.size() - 1);
        for (int i = len - 2; i >= 0; i--) {
            Node node = nodes.get(i);
            Node newNode = turn(node, standardNode);
            nodes.add(newNode);
        }
    }

    private Node turn(Node target, Node standard) {
        int distX = target.x - standard.x;
        int distY = target.y - standard.y;
        return new Node(standard.x - distY, standard.y + distX);
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