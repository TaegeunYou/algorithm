package main.java.programmers.level3.보행자_천국;

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] colDp = initialColDp(m, n, cityMap);
        int[][] rowDp = initialRowDp(m, n, cityMap);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int tmp = cityMap[i][j];
                if (tmp == 1) {
                    continue;
                }
                int up = cityMap[i - 1][j];
                int left = cityMap[i][j - 1];
                int upSum = 0;
                int leftSum = 0;
                //위에서 오는거
                if (up == 2) {
                    upSum = colDp[i - 1][j];
                } else {
                    upSum = (colDp[i - 1][j] + rowDp[i - 1][j]);
                }
                //왼쪽에서 오는거
                if (left == 2) {
                    leftSum = rowDp[i][j - 1];
                } else {
                    leftSum = (rowDp[i][j - 1] + colDp[i][j - 1]);
                }
                colDp[i][j] = upSum % MOD;
                rowDp[i][j] = leftSum % MOD;
            }
        }
        return (colDp[m - 1][n - 1] + rowDp[m - 1][n - 1]) % MOD;
    }

    private int[][] initialColDp(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            int tmp = cityMap[i][0];
            if (tmp == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        return dp;
    }

    private int[][] initialRowDp(int m, int n, int[][] cityMap) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            int tmp = cityMap[0][i];
            if (tmp == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        return dp;
    }
}
