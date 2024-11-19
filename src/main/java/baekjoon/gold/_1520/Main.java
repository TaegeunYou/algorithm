package main.java.baekjoon.gold._1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] board = new int[m][n];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st1.nextToken());
                board[i][j] = tmp;
                queue.add(new Point(i, j, tmp));
            }
        }
        int result = execute(board, queue);
        System.out.println(result);
        br.close();
    }

    private int execute(int[][] board, PriorityQueue<Point> queue) {
        int[][] dp = new int[board.length][board[0].length];
        dp[0][0] = 1;
        int target = board[board.length - 1][board[0].length - 1];
        while (!queue.isEmpty() && queue.peek().num >= target) {
            Point point = queue.poll();
            process(point.x - 1, point.y, board, dp, point);
            process(point.x + 1, point.y, board, dp, point);
            process(point.x, point.y - 1, board, dp, point);
            process(point.x, point.y + 1, board, dp, point);
        }
        return dp[board.length - 1][board[0].length - 1];
    }

    private void process(int x, int y, int[][] board, int[][] dp, Point point) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
        if (board[x][y] >= point.num) {
            return;
        }
        dp[x][y] += dp[point.x][point.y];
    }

    class Point implements Comparable<Point> {
        int x;
        int y;
        int num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        public int compareTo(Point o) {
            return o.num - this.num;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
