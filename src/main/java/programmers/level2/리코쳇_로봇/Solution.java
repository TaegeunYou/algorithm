package main.java.programmers.level2.리코쳇_로봇;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        int[][] ch = new int[board.length][board[0].length()];
        Node start = findStart(board);
        queue.offer(start);
        ch[start.x][start.y] = 1;
        int distance = 1;
        boolean flag = false;
        while (!queue.isEmpty()) {
            if (flag) break;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    Node move = move(node, dx[j], dy[j], board);
                    if (move != null && ch[move.x][move.y] == 0) {
                        if (board[move.x].charAt(move.y) == 'G') {
                            answer = Math.min(answer, distance);
                            flag = true;
                            break;
                        } else {
                            queue.offer(move);
                            ch[move.x][move.y] = 1;
                        }
                    }
                }
            }
            distance++;
        }
        if (flag) return answer;
        return -1;
    }

    private Node findStart(String[] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') return new Node(i, j);
            }
        }
        return null;
    }

    private Node move(Node node, int dx, int dy, String[] board) {
        int tmpX = node.x;
        int tmpY = node.y;
        while (true) {
            int newX = tmpX + dx;
            int newY = tmpY + dy;
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length() && board[newX].charAt(newY) != 'D') {
                tmpX = newX;
                tmpY = newY;
            } else {
                break;
            }
        }
        if (tmpX == node.x && tmpY == node.y) return null;
        else return new Node(tmpX, tmpY);
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