package main.java.programmers.level2.거리두기_확인하기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            if (check(places[i])) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }

    private boolean check(String[] board) {
        boolean flag = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'P') {
                    int[][] ch = new int[board.length][board[0].length()];
                    Queue<Node> queue = new LinkedList<>();
                    queue.offer(new Node(i, j));
                    ch[i][j] = 1;
                    int distance = 1;
                    while (!queue.isEmpty() && distance <= 2) {
                        int len = queue.size();
                        for (int q = 0; q < len; q++) {
                            Node node = queue.poll();
                            for (int k = 0; k < dx.length; k++) {
                                int nx = node.x + dx[k];
                                int ny = node.y + dy[k];
                                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length() && ch[nx][ny] == 0) {
                                    if (board[nx].charAt(ny) == 'O') {
                                        queue.offer(new Node(nx, ny));
                                        ch[nx][ny] = 1;
                                    } else if (board[nx].charAt(ny) == 'P') {
                                        flag = false;
                                        break;
                                    }
                                }
                            }
                        }
                        distance++;
                    }
                }
            }
        }
        return flag;
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