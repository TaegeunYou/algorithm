package main.java.programmers.level3.경주로_건설;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution2 {
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        int boardLength = board.length;
        int[][] priceMinCh = new int[boardLength][boardLength];
        int[] tmp = new int[boardLength];
        Arrays.fill(tmp, Integer.MAX_VALUE);
        for (int i = 0; i < boardLength; i++) {
            priceMinCh[i] = Arrays.copyOf(tmp, boardLength);
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, 0, 0, new boolean[boardLength][boardLength], 0, 0));
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node node = queue.pollFirst();
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx >= 0 && nx < boardLength && ny >= 0 && ny < boardLength && board[nx][ny] == 0 && !node.ch[nx][ny]) {
                        boolean isCorner = !(node.x == 0 && node.y == 0) && !(dx[j] == node.dx && dy[j] == node.dy);
                        int price = node.sum + 100 + (isCorner ? 500 : 0);
                        if (price - 500 > priceMinCh[nx][ny] || price >= answer) continue;
                        priceMinCh[nx][ny] = Math.min(priceMinCh[nx][ny], price);
                        if (nx == boardLength - 1 && ny == boardLength - 1) {       //도착점 도착
                            answer = Math.min(answer, price);
                        } else {
                            boolean[][] arr = copyArray(node.ch);
                            arr[nx][ny] = true;
                            queue.offerLast(new Node(nx, ny, price, arr, dx[j], dy[j]));
                        }
                    }
                }
            }
        }
        return answer;
    }

    private boolean[][] copyArray(boolean[][] arr) {
        boolean[][] newArr = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return newArr;
    }

    class Node {
        int x;
        int y;
        int sum;
        boolean[][] ch;
        int dx;
        int dy;

        public Node(int x, int y, int sum, boolean[][] ch, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.ch = ch;
            this.dx = dx;
            this.dy = dy;
        }
    }
}