package main.java.baekjoon.gold._3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = 2;        //사과
        }
        int l = Integer.parseInt(br.readLine());
        Deque<Direction> queue = new ArrayDeque<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            queue.offerLast(new Direction(second, direction));
        }
        int result = execute(board, queue);
        System.out.println(result);
    }

    private int execute(int[][] board, Deque<Direction> directions) {
        int directionIdx = 1;
        int x = 0;
        int y = 0;
        int second = 0;
        Deque<Snake> snakes = new ArrayDeque<>();
        snakes.offerFirst(new Snake(x, y));
        while (true) {
            second++;
            x = x + dx[directionIdx];
            y = y + dy[directionIdx];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                break;
            }
            boolean bodyCrash = false;
            for (Snake snake : snakes) {
                if (snake.x == x && snake.y == y) {
                    bodyCrash = true;
                    break;
                }
            }
            if (bodyCrash) {
                break;
            }
            snakes.offerFirst(new Snake(x, y));
            if (board[x][y] != 2) {
                snakes.pollLast();
            } else {
                board[x][y] = 0;
            }
            if (directions.isEmpty()) {
                continue;
            }
            Direction nextDirection = directions.peekFirst();
            if (nextDirection.second == second) {
                directions.pollFirst();
                if (nextDirection.direction == 'L') {
                    directionIdx = (directionIdx + 3) % 4;
                } else {
                    directionIdx = (directionIdx + 1) % 4;
                }
            }
        }
        return second;
    }

    private class Snake {
        int x;
        int y;

        public Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Direction {
        int second;
        char direction;

        public Direction(int second, char direction) {
            this.second = second;
            this.direction = direction;
        }
    }



    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
