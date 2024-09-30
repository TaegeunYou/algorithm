package main.java.programmers.level2.PCCP_기출문제_2번_석유_시추;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    int[][] land;
    int n, m;
    int[][] ch;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int blockNum = 1;
    public int solution(int[][] land) {
        int answer = Integer.MIN_VALUE;
        this.land = land;
        this.n = land.length;
        this.m = land[0].length;
        this.ch = new int[n][m];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0 && land[i][j] == 1) {
                    int count = bfs(i, j, blockNum);
                    map.put(blockNum, count);
                    blockNum++;
                }
            }
        }
        HashMap<Integer, HashSet<Integer>> totalMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] != 0) {
                    HashSet<Integer> set = totalMap.getOrDefault(j, new HashSet<>());
                    set.add(ch[i][j]);
                }
            }
        }
        for (int i : totalMap.keySet()) {
            HashSet<Integer> blockNums = totalMap.get(i);
            int total = 0;
            for (int blockNum : blockNums) {
                total += map.get(blockNum);
            }
            answer = Math.max(answer, total);
        }
        return answer;
    }

    private int bfs(int x, int y, int blockNum) {
        int count = 0;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(x, y));
        ch[x][y] = blockNum;
        count++;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                Node node = queue.pollFirst();
                for (int i = 0; i < dx.length; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0 && land[nx][ny] == 1) {
                        queue.offerLast(new Node(nx, ny));
                        ch[nx][ny] = blockNum;
                        count++;
                    }
                }
            }
        }
        return count;
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