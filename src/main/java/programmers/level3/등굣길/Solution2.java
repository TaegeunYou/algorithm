package main.java.programmers.level3.등굣길;

class Solution2 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] puddlesArr = new int[n + 1][m + 1];
        for (int[] arr: puddles) {
            puddlesArr[arr[1]][arr[0]] = 1;
        }
        int[][] board = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            if (puddlesArr[i][1] != 1) board[i][1] = 1;
            else break;
        }
        for (int i = 1; i <= m; i++) {
            if (puddlesArr[1][i] != 1) board[1][i] = 1;
            else break;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (puddlesArr[i][j] != 1) {
                    board[i][j] = (board[i - 1][j] + board[i][j - 1]) % 1000000007;
                }
            }
        }
        return board[n][m];
    }

}