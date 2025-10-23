package main.java.baekjoon.gold._12100;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int[][] originalBoard;
    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    List<Integer> directions = new ArrayList<>();
    boolean isMove;
    boolean isMerge;
    int answer = -1;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        originalBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                originalBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi();
        System.out.println(answer);
    }

    private void moveDirection(int direction) {
        if (direction == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        move(direction, i, j);
                    }
                }
            }
        } else if (direction == 1) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] != 0) {
                        move(direction, j, i);
                    }
                }
            }
        } else if (direction == 2) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        move(direction, i, j);
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] != 0) {
                        move(direction, j, i);
                    }
                }
            }
        }
    }

    private void move(int direction, int i, int j) {
        int nx = i;
        int ny = j;
        for (int k = 1; k < n; k++) {
            int nextX = nx + dx[direction];
            int nextY = ny + dy[direction];
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || board[nextX][nextY] != 0) {
                break;
            }
            nx = nextX;
            ny = nextY;
        }
        if (nx != i || ny != j) {
            isMove = true;
            board[nx][ny] = board[i][j];
            board[i][j] = 0;
        }
    }

    private void process() {
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = originalBoard[i][j];
            }
        }
        for (int direction : directions) {
            //기울인쪽으로 붙이기
            isMove = false;
            moveDirection(direction);
            //합치기
            if (merge(direction)) {
                moveDirection(direction);
            }
        }
        calculateMax();
    }

    private void mergePair(int i, int j, int pairX, int pairY) {
        if (pairX < 0 || pairY < 0 || pairX >= n || pairY >= n) {
            return;
        }
        if (board[i][j] == board[pairX][pairY]) {
            board[pairX][pairY] = 0;
            board[i][j] = board[i][j] * 2;
            isMerge = true;
        }
    }

    private boolean merge(int direction) {
        isMerge = false;
        if (direction == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        int pairX = i + 1;
                        int pairY = j;
                        mergePair(i, j, pairX, pairY);
                    }
                }
            }
        } else if (direction == 1) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] != 0) {
                        int pairX = j;
                        int pairY = i - 1;
                        mergePair(j, i, pairX, pairY);
                    }
                }
            }
        } else if (direction == 2) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != 0) {
                        int pairX = i - 1;
                        int pairY = j;
                        mergePair(i, j, pairX, pairY);
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[j][i] != 0) {
                        int pairX = j;
                        int pairY = i + 1;
                        mergePair(j, i, pairX, pairY);
                    }
                }
            }
        }
        return isMerge;
    }

    private void calculateMax() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
    }

    private void combi() {
        if (directions.size() == 5) {
            process();
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            directions.add(i);
            combi();
            directions.remove(directions.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
