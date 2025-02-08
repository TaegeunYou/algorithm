package main.java.baekjoon.gold._17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        int t = Integer.parseInt(st1.nextToken());
        board = new int[r][c];
        int downPurifierX = -1;
        for (int i = 0; i < r; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
                if (board[i][j] == -1) {
                    downPurifierX = i;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            //확산
            diffusion();
            //공기청정기
            purifier(downPurifierX);
        }
        //결과
        int result = getResult();
        System.out.println(result);
    }

    private void diffusion() {
        int[][] updateBoard = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] < 5) {
                    continue;
                }
                int diffusionAmount = board[i][j] / 5;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || board[nx][ny] == -1) {
                        continue;
                    }
                    updateBoard[nx][ny] += diffusionAmount;
                    updateBoard[i][j] -= diffusionAmount;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += updateBoard[i][j];
            }
        }
    }

    private void purifier(int downPurifierX) {
        int[][] newBoard = new int[board.length][board[0].length];
        int upPurifierX = downPurifierX - 1;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                int tmp = board[x][y];
                if (tmp == -1) {
                    newBoard[x][y] = tmp;
                } else if ((y == 0 && x == upPurifierX - 1) || (y == 0 && x == downPurifierX + 1)) {
                    continue;
                } else if (y == 0 && x < upPurifierX - 1) {
                    //아래
                    newBoard[x + 1][y] = tmp;
                } else if (x == 0) {
                    //왼쪽
                    newBoard[x][y - 1] = tmp;
                } else if (y == board[0].length - 1 && x <= upPurifierX) {
                    //위
                    newBoard[x - 1][y] = tmp;
                } else if (x == upPurifierX) {
                    //오른쪽
                    newBoard[x][y + 1] = tmp;
                } else if (y == 0 && x > downPurifierX + 1) {
                    //위로
                    newBoard[x - 1][y] = tmp;
                } else if (x == board.length - 1) {
                    //왼쪽
                    newBoard[x][y - 1] = tmp;
                } else if (y == board[0].length - 1 && x >= downPurifierX) {
                    //아래
                    newBoard[x + 1][y] = tmp;
                } else if (x == downPurifierX) {
                    //오른쪽
                    newBoard[x][y + 1] = tmp;
                } else {
                    //그대로
                    newBoard[x][y] = tmp;
                }
            }
        }
        board = newBoard;
    }

    private int getResult() {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != -1) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
