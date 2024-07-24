package main.java.inflearn.DFS_BFS;

import java.util.Scanner;

class Main0815 {

    static int n;
    static int m;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] pi;
    static int totalPizza = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
                if (board[i][j] == 2) totalPizza++;
            }
        }
        pi = new int[totalPizza][n][n];
        int pizzaIdx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    int[][] dis = new int[n][n];
                    dis[i][j] = 0;
                    setDisBoard(i, j, dis);
                    dfs(i, j, dis);
                    for (int q = 0; q < n; q++) {
                        for (int w = 0; w < n; w++) {
                            if (board[q][w] == 1) {
                                pi[pizzaIdx][q][w] = dis[q][w];
                            }
                        }
                    }
                    pizzaIdx++;
                }
            }
        }
        int[] pizzaPos = new int[m];
        combi(0, 0, pizzaPos);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int[][] dis) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int newDis = dis[x][y] + 1;
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && dis[nx][ny] > newDis) {
                dis[nx][ny] = newDis;
                dfs(nx, ny, dis);
            }
        }
    }

    public static void setDisBoard(int x, int y, int[][] dis) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x != i || y != j) dis[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void combi(int L, int s, int[] pizzaPos) {
        if (L == m) {
            answer = Math.min(answer, getCityPizzaDis(pizzaPos));
            return;
        }
        for (int i = s; i < totalPizza; i++) {
            pizzaPos[L] = i;
            combi(L + 1, i + 1, pizzaPos);
        }
    }

    public static int getCityPizzaDis(int[] pizzaPos) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    for (int k : pizzaPos) {
                        min = Math.min(min, pi[k][i][j]);
                    }
                    sum += min;
                }
            }
        }
        return sum;
    }

}