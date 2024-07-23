package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

/**
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 */
class Main0810 {

    static int answer = 0;
    static int[][] maze = new int[7][7];

    //6시, 9시, 12시, 3시 순서
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, -1, 0, 1 };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                maze[i][j] = in.nextInt();
            }
        }
        maze[0][0] = 2;
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int row, int col) {
        if (row == 6 && col == 6) {
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx != -1 && ny != -1 && nx != 7 && ny != 7 && maze[nx][ny] == 0) {
                maze[nx][ny] = 2;
                dfs(nx, ny);
                maze[nx][ny] = 0;
            }
        }
    }

}