package main.java.baekjoon.gold._5427;

import java.io.*;
import java.util.*;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st1.nextToken());
            int h = Integer.parseInt(st1.nextToken());
            char[][] board = new char[h][w];
            Node start = null;
            List<Node> fires = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = str.charAt(j);
                    if (board[i][j] == '@') {
                        start = new Node(i, j, board[i][j]);
                        board[i][j] = '.';
                    } else if (board[i][j] == '*') {
                        fires.add(new Node(i, j, board[i][j]));
                        board[i][j] = '.';
                    }
                }
            }
            String result = execute(w, h, board, start, fires);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private String execute(int w, int h, char[][] board, Node start, List<Node> fires) {
        Deque<Node> queue = new ArrayDeque<>();
        for (Node fire : fires) {
            queue.offerLast(fire);
        }
        queue.offerLast(start);
        int time = -1;
        while (!queue.isEmpty()) {
            time++;
            int queueSize = queue.size();
            boolean isMove = false;
            for (int i = 0; i < queueSize; i++) {
                Node node = queue.pollFirst();
                if (node.x < 0 || node.y < 0 || node.x >= h || node.y >= w) {
                    if (node.type == '@') {
                        return String.valueOf(time);
                    } else {
                        continue;
                    }
                }
                char tmp = board[node.x][node.y];
                if (node.type == '*') {
                    if (tmp == '@' || tmp == '.') {
                        board[node.x][node.y] = '*';
                    } else {
                        continue;
                    }
                } else if (node.type == '@') {
                    if (tmp == '.') {
                        board[node.x][node.y] = '@';
                        isMove = true;
                    } else {
                        continue;
                    }
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    queue.offerLast(new Node(nx, ny, node.type));
                }
            }
            if (!isMove) {
                return "IMPOSSIBLE";
            }
        }
        return "IMPOSSIBLE";
    }

    private class Node {
        int x;
        int y;
        char type;
        public Node(int x, int y, char type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
