package main.java.baekjoon.gold._1600;

import java.io.*;
import java.util.*;

public class Main {

    int k;
    int w;
    int h;
    int[][] board;
    int[] dxh = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dyh = {1, 2, 2, 1, -1, -2, -2, -1};
    int[] dxm = {-1, 0, 1, 0};
    int[] dym = {0, 1, 0 ,-1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st1.nextToken());
        h = Integer.parseInt(st1.nextToken());
        board = new int[h][w];
        for (int i = 0; i < h; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int result = execute();
        System.out.println(result);
    }

    private int execute() {
        boolean[][][] visited = new boolean[h][w][k + 1];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, 0, k));
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (visited[node.x][node.y][node.remainK]) {
                    continue;
                }
                if (node.x == h - 1 && node.y == w - 1) {
                    return count;
                }
                visited[node.x][node.y][node.remainK] = true;
                if (node.remainK > 0) {
                    for (int j = 0; j < dxh.length; j++) {
                        int nx = node.x + dxh[j];
                        int ny = node.y + dyh[j];
                        if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                            continue;
                        }
                        if (visited[nx][ny][node.remainK - 1] || board[nx][ny] == 1) {
                            continue;
                        }
                        queue.offerLast(new Node(nx, ny, node.remainK - 1));
                    }
                }
                for (int j = 0; j < dxm.length; j++) {
                    int nx = node.x + dxm[j];
                    int ny = node.y + dym[j];
                    if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                        continue;
                    }
                    if (visited[nx][ny][node.remainK] || board[nx][ny] == 1) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny, node.remainK));
                }
            }
        }
        return -1;
    }

    private class Node {
        int x;
        int y;
        int remainK;
        public Node(int x, int y, int remainK) {
            this.x = x;
            this.y = y;
            this.remainK = remainK;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
