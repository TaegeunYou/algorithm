package main.java.baekjoon.gold._6593;

import java.io.*;
import java.util.*;

public class Main {

    int[] dx = {-1, 0, 1, 0, 0, 0};
    int[] dy = {0, 1, 0, -1, 0, 0};
    int[] dz = {0, 0, 0, 0, 1, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            char[][][] board = new char[L][R][C];
            Node start = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = str.charAt(k);
                        if (board[i][j][k] == 'S') {
                            start = new Node(j, k, i);
                            board[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            String result = execute(L, R, C, board, start);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private String execute(int L, int R, int C, char[][][] board, Node start) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(start);
        int time = -1;
        while (!queue.isEmpty()) {
            time++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node node = queue.pollFirst();
                if (board[node.z][node.x][node.y] == 'S') {
                    continue;
                }
                if (board[node.z][node.x][node.y] == 'E') {
                    return "Escaped in " + time + " minute(s).";
                }
                board[node.z][node.x][node.y] = 'S';
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    int nz = node.z + dz[j];
                    if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) {
                        continue;
                    }
                    if (board[nz][nx][ny] == '#' || board[nz][nx][ny] == 'S') {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny, nz));
                }
            }
        }
        return "Trapped!";
    }

    private class Node {
        int x;
        int y;
        int z;
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
