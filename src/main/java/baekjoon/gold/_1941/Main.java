package main.java.baekjoon.gold._1941;

import java.io.*;
import java.util.*;

public class Main {

    List<Node> combis = new ArrayList<>();
    List<Node> nodes = new ArrayList<>();
    char[][] board;
    int answer = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = line.charAt(j);
                nodes.add(new Node(i, j, board[i][j]));
            }
        }
        combi(0, 0);
        System.out.println(answer);
    }

    private void combi(int idx, int countY) {
        if (countY >= 4) {
            return;
        }
        if (combis.size() == 7) {
            if (isConnect()) {
                answer++;
            }
            return;
        }
        if (idx == nodes.size()) {
            return;
        }
        //선택 o
        Node tmp = nodes.get(idx);
        combis.add(tmp);
        if (tmp.c == 'Y') {
            combi(idx + 1, countY + 1);
        } else {
            combi(idx + 1, countY);
        }
        combis.remove(combis.size() - 1);
        //선택 x
        combi(idx + 1, countY);
    }

    private boolean isConnect() {
        boolean[][] visited = new boolean[5][5];
        Deque<Node> queue = new ArrayDeque<>();
        Node start = combis.get(0);
        queue.offerLast(start);
        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y]) {
                continue;
            }
            count++;
            visited[node.x][node.y] = true;
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                boolean flag = false;
                for (int j = 0; j < combis.size(); j++) {
                    Node tmp = combis.get(j);
                    if (tmp.x == nx && tmp.y == ny) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    queue.offerLast(new Node(nx, ny, board[nx][ny]));
                }
            }
        }
        return count == 7;
    }

    private class Node {
        int x;
        int y;
        char c;
        public Node(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
