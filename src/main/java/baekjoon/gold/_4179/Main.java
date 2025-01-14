package main.java.baekjoon.gold._4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] board = new char[row][col];
        Position jPosition = null;
        List<Position> fPositions = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'J') {
                    jPosition = new Position(i, j);
                }
                if (board[i][j] == 'F') {
                    fPositions.add(new Position(i, j));
                }
            }
        }
        int result = execute(board, jPosition, fPositions);
        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    private int execute(char[][] board, Position jPosition, List<Position> fPositions) {
        boolean[][] jVisited = new boolean[board.length][board[0].length];
        boolean[][] fVisited = new boolean[board.length][board[0].length];
        Deque<Position> jQueue = new ArrayDeque<>();
        Deque<Position> fQueue = new ArrayDeque<>();
        jQueue.offerLast(jPosition);
        jVisited[jPosition.x][jPosition.y] = true;
        for (Position position : fPositions) {
            fQueue.offerLast(position);
            fVisited[position.x][position.y] = true;
        }
        int result = 0;
        while (!jQueue.isEmpty()) {
            result++;
            int fQueueLen = fQueue.size();
            int jQueueLen = jQueue.size();
            for (int i = 0; i < fQueueLen; i++) {
                Position fPoll = fQueue.pollFirst();
                for (int j = 0; j < dx.length; j++) {
                    int nx = fPoll.x + dx[j];
                    int ny = fPoll.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || fVisited[nx][ny]) {
                        continue;
                    }
                    if (board[nx][ny] == '.' || board[nx][ny] == 'J') {
                        fQueue.offerLast(new Position(nx, ny));
                        fVisited[nx][ny] = true;
                    }
                }
            }
            for (int i = 0; i < jQueueLen; i++) {
                Position jPoll = jQueue.pollFirst();
                for (int j = 0; j < dx.length; j++) {
                    int nx = jPoll.x + dx[j];
                    int ny = jPoll.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                        return result;
                    }
                    if (board[nx][ny] == '.' && !jVisited[nx][ny] && !fVisited[nx][ny]) {
                        jQueue.offerLast(new Position(nx, ny));
                        jVisited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    private class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
