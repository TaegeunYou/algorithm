package main.java.programmers.level3.등굣길;

import java.util.ArrayDeque;

/**
 * m	n	puddles	return
 * 4	3	[[2, 2]]	4
 */
class Solution {
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] puddlesArr = new int[n + 1][m + 1];
        for (int[] arr: puddles) {
            puddlesArr[arr[1]][arr[0]] = 1;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(1, 1));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx == n && ny == m) {
                        answer = (answer + 1) % 1000000007;
                    } else if (nx <= n && ny <= m && puddlesArr[nx][ny] != 1) {
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return answer;
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