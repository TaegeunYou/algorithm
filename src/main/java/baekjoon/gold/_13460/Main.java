package main.java.baekjoon.gold._13460;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    char[][] startBoard;
    List<Integer> directions = new ArrayList<>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int answer = Integer.MAX_VALUE;
    int startRedX;
    int startRedY;
    int startBlueX;
    int startBlueY;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startBoard = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                startBoard[i][j] = str.charAt(j);
                if (startBoard[i][j] == 'R') {
                    startRedX = i;
                    startRedY = j;
                } else if (startBoard[i][j] == 'B') {
                    startBlueX = i;
                    startBlueY = j;
                }
            }
        }
        combi();
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private int process() {
        //했는데 빨강 파랑 둘 다 안움직이면 최소 경우의수가 아니여서 즉시 끝내기
        int turn = 0;
        int redX = startRedX;
        int redY = startRedY;
        int blueX = startBlueX;
        int blueY = startBlueY;
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = startBoard[i][j];
            }
        }
        for (int direction : directions) {
            turn++;
            //파란 구슬이 빠지는지 확인
            for (int i = 1; i <= 10; i++) {
                int blueNx = blueX + dx[direction] * i;
                int blueNy = blueY + dy[direction] * i;
                if (blueNx < 0 || blueNy < 0 || blueNx >= n || blueNy >= m || board[blueNx][blueNy] == '#') {
                    break;
                }
                if (board[blueNx][blueNy] == 'O') {
                    return 0;
                }
            }
            //빨간 구슬이 빠지는지 확인
            for (int i = 1; i <= 10; i++) {
                int redNx = redX + dx[direction] * i;
                int redNy = redY + dy[direction] * i;
                if (redNx < 0 || redNy < 0 || redNx >= n || redNy >= m || board[redNx][redNy] == '#') {
                    break;
                }
                if (board[redNx][redNy] == 'O') {
                    return turn;
                }
            }
            // 벽에 막히는 경우, 다른 구슬에 막히는 경우
            boolean move = false;
            for (int i = 0; i < 10; i++) {
                int redNx = redX + dx[direction];
                int redNy = redY + dy[direction];
                int blueNx = blueX + dx[direction];
                int blueNy = blueY + dy[direction];
                //벽에 막히는 경우
                boolean redWall = false;
                boolean blueWall = false;
                if (board[redNx][redNy] == '#') {
                    redWall = true;
                }
                if (board[blueNx][blueNy] == '#') {
                    blueWall = true;
                }
                if (!redWall) {
                    board[redX][redY] = '.';
                }
                if (!blueWall) {
                    board[blueX][blueY] = '.';
                }
                if (!redWall) {
                    if (board[redNx][redNy] == '.') {
                        board[redNx][redNy] = 'R';
                        redX = redNx;
                        redY = redNy;
                        move = true;
                    } else {
                        board[redX][redY] = 'R';
                    }
                }
                if (!blueWall) {
                    if (board[blueNx][blueNy] == '.') {
                        board[blueNx][blueNy] = 'B';
                        blueX = blueNx;
                        blueY = blueNy;
                        move = true;
                    } else {
                        board[blueX][blueY] = 'B';
                    }
                }
            }
            if (!move) {
                return 0;
            }
        }
        return 0;
    }

    private void combi() {
        if (directions.size() == 10) {
            int turn = process();
            if (turn != 0) {
                answer = Math.min(answer, turn);
            }
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
