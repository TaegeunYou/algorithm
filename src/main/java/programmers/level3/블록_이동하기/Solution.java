package main.java.programmers.level3.블록_이동하기;

import java.util.*;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][][][] visited;
    int[][] board;
    int N;

    public int solution(int[][] board) {
        int answer = 0;
        N = board.length - 1;
        this.board = board;
        visited = new boolean[101][101][101][101];
        int distance = 0;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, 0, 0, 1));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if ((node.x1 == N && node.y1 == N) || (node.x2 == N && node.y2 == N)) {
                    return distance;
                }
                if (visited[node.x1][node.y1][node.x2][node.y2]) {
                    continue;
                }
                visited[node.x1][node.y1][node.x2][node.y2] = true;
                visited[node.x2][node.y2][node.x1][node.y1] = true;
                //8가지 선택지
                for (int j = 0; j < dx.length; j++) {
                    int nx1 = node.x1 + dx[j];
                    int ny1 = node.y1 + dy[j];
                    int nx2 = node.x2 + dx[j];
                    int ny2 = node.y2 + dy[j];
                    boolean flag = check(nx1, ny1, nx2, ny2);
                    if (flag) {
                        queue.offerLast(new Node(nx1, ny1, nx2, ny2));
                    }
                }
                if (node.y1 - node.y2 != 0) { //가로 상태
                    if (node.x1 > node.x2) {
                        int tmpX = node.x1;
                        int tmpY = node.y1;
                        node.x1 = node.x2;
                        node.y1 = node.y2;
                        node.x2 = tmpX;
                        node.y2 = tmpY;
                    }
                    int nx11 = node.x1;
                    int ny11 = node.y1;
                    int nx12 = node.x1 - 1;
                    int ny12 = node.y1;
                    if (check(nx11, ny11, nx12, ny12) && board[node.x1 - 1][node.y1 + 1] == 0) {
                        queue.offerLast(new Node(nx11, ny11, nx12, ny12));
                    }
                    int nx21 = node.x1;
                    int ny21 = node.y1;
                    int nx22 = node.x1 + 1;
                    int ny22 = node.y1;
                    if (check(nx21, ny21, nx22, ny22) && board[node.x1 + 1][node.y1 + 1] == 0) {
                        queue.offerLast(new Node(nx21, ny21, nx22, ny22));
                    }
                    int nx31 = node.x2 - 1;
                    int ny31 = node.y2;
                    int nx32 = node.x2;
                    int ny32 = node.y2;
                    if (check(nx31, ny31, nx32, ny32) && board[node.x2 - 1][node.y2 - 1] == 0) {
                        queue.offerLast(new Node(nx31, ny31, nx32, ny32));
                    }
                    int nx41 = node.x2 + 1;
                    int ny41 = node.y2;
                    int nx42 = node.x2;
                    int ny42 = node.y2;
                    if (check(nx41, ny41, nx42, ny42) && board[node.x2 + 1][node.y2 - 1] == 0) {
                        queue.offerLast(new Node(nx41, ny41, nx42, ny42));
                    }
                } else {
                    if (node.y1 > node.y2) {
                        int tmpX = node.x1;
                        int tmpY = node.y1;
                        node.x1 = node.x2;
                        node.y1 = node.y2;
                        node.x2 = tmpX;
                        node.y2 = tmpY;
                    }
                    int nx11 = node.x1;
                    int ny11 = node.y1;
                    int nx12 = node.x1;
                    int ny12 = node.y1 - 1;
                    if (check(nx11, ny11, nx12, ny12) && board[node.x1 + 1][node.y1 - 1] == 0) {
                        queue.offerLast(new Node(nx11, ny11, nx12, ny12));
                    }
                    int nx21 = node.x1;
                    int ny21 = node.y1;
                    int nx22 = node.x1;
                    int ny22 = node.y1 + 1;
                    if (check(nx21, ny21, nx22, ny22) && board[node.x1 + 1][node.y1 + 1] == 0) {
                        queue.offerLast(new Node(nx21, ny21, nx22, ny22));
                    }
                    int nx31 = node.x2;
                    int ny31 = node.y2 - 1;
                    int nx32 = node.x2;
                    int ny32 = node.y2;
                    if (check(nx31, ny31, nx32, ny32) && board[node.x2 - 1][node.y2 - 1] == 0) {
                        queue.offerLast(new Node(nx31, ny31, nx32, ny32));
                    }
                    int nx41 = node.x2;
                    int ny41 = node.y2 + 1;
                    int nx42 = node.x2;
                    int ny42 = node.y2;
                    if (check(nx41, ny41, nx42, ny42) && board[node.x2 - 1][node.y2 + 1] == 0) {
                        queue.offerLast(new Node(nx41, ny41, nx42, ny42));
                    }
                }
            }
            distance++;
        }
        return answer;
    }

    private boolean check(int nx1, int ny1, int nx2, int ny2) {
        if (nx1 < 0 || ny1 < 0 || nx1 > N || ny1 > N) {
            return false;
        }
        if (nx2 < 0 || ny2 < 0 || nx2 > N || ny2 > N) {
            return false;
        }
        if (visited[nx1][ny1][nx2][ny2]) {
            return false;
        }
        if (board[nx1][ny1] == 1 || board[nx2][ny2] == 1) {
            return false;
        }
        return true;
    }

    private class Node {
        int x1;
        int y1;
        int x2;
        int y2;

        public Node(int x1, int y1, int x2, int y2) {
            if (x1 > x2 || (x1 == x2 && y1 > y2)) {
                int tmpX = x1;
                int tmpY = y1;
                x1 = x2;
                y1 = y2;
                x2 = tmpX;
                y2 = tmpY;
            }
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
