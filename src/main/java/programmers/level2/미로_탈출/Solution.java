package main.java.programmers.level2.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int n, m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        char[][] board = new char[n][m];
        Node start = null;
        Node lever = null;
        Node end = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = maps[i].charAt(j);
                if (board[i][j] == 'S') start = new Node(i, j);
                else if (board[i][j] == 'L') lever = new Node(i, j);
                else if (board[i][j] == 'E') end = new Node(i, j);
            }
        }
        int a = bfs(start, lever, board);
        int b = bfs(lever, end, board);
        if (a == -1 || b == -1) return -1;
        else return a + b;
    }

    private int bfs(Node start, Node end, char[][] board) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] ch = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        ch[start.x][start.y] = 1;
        int answer = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0 && board[nx][ny] != 'X') {
                        if (nx == end.x && ny == end.y) return answer;
                        queue.offer(new Node(nx, ny));
                        ch[nx][ny] = 1;
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}