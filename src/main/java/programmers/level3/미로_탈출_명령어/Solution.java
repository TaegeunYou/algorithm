package main.java.programmers.level3.미로_탈출_명령어;

import java.util.*;

class Solution {

    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    String dxdy = "dlru";

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        Map<String, Boolean> map = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y, ""));
        int dist = 0;
        while (!queue.isEmpty() && dist <= k) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (dist == k && node.x == r && node.y == c) {
                    return node.route;
                }
                int minDist = Math.abs(node.x - r) + Math.abs(node.y - c);
                int remainDist = k - dist;
                if (minDist > remainDist) {
                    continue;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx <= 0 || ny <= 0 || nx > n || ny > m) {
                        continue;
                    }
                    String key = nx + "." + ny + "." + dist;
                    if (map.get(key) != null) {
                        continue;
                    }
                    map.put(key, true);
                    queue.offerLast(new Node(nx, ny, node.route + dxdy.charAt(j)));
                }
            }
            dist++;
        }
        return "impossible";
    }

    private class Node {
        int x;
        int y;
        String route;

        public Node(int x, int y, String route) {
            this.x = x;
            this.y = y;
            this.route = route;
        }
    }
}
