package main.java.programmers.level2.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = maps.length;
        int m = maps[0].length;
        int[][] ch = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        ch[0][0] = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Node node = queue.poll();
                for (int i = 0; i < dx.length; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && ch[nx][ny] == 0) {
                        if (nx == n - 1 && ny == m - 1) {
                            return node.level + 1;
                        }
                        ch[nx][ny] = 1;
                        queue.offer(new Node(nx, ny, node.level + 1));
                    }
                }
            }
        }
        return -1;
    }

    class Node {
        int x;
        int y;
        int level;

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
}