package main.java.programmers.level2.무인도_여행;

import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        ArrayList<Integer> answers = new ArrayList<>();
        int n = maps.length;
        int m = maps[0].length();
        int[][] ch = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0 , -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char start = maps[i].charAt(j);
                if (start != 'X' && ch[i][j] == 0) {
                    int sum = 0;
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j));
                    sum += (start - '0');
                    ch[i][j] = 1;
                    while (!queue.isEmpty()) {
                        Node node = queue.poll();
                        for (int k = 0; k < dx.length; k++) {
                            int nx = node.x + dx[k];
                            int ny = node.y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && ch[nx][ny] == 0 && maps[nx].charAt(ny) != 'X') {
                                queue.offer(new Node(nx, ny));
                                sum += (maps[nx].charAt(ny) - '0');
                                ch[nx][ny] = 1;
                            }
                        }
                    }
                    answers.add(sum);
                }
            }
        }
        if (answers.isEmpty()) answers.add(-1);
        Collections.sort(answers);
        return answers.stream().mapToInt(it -> it).toArray();
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