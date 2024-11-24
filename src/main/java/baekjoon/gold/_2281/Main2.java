package main.java.baekjoon.gold._2281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(n, m, arr);
        System.out.println(result);
        br.close();
    }

    private int execute(int n, int m, int[] arr) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[1][m - arr[1]] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j] != -1) {
                    //같은 줄에 들어가기
                    if (j >= arr[i] + 1) {
                        int newRemain = j - (arr[i] + 1);
                        if (dp[i][newRemain] == -1) {
                            dp[i][newRemain] = dp[i - 1][j];
                        } else {
                            dp[i][newRemain] = Math.min(dp[i][newRemain], dp[i - 1][j]);
                        }
                    }
                    //다음 줄에 들어가기
                    int tmpSum = dp[i - 1][j] + (int) Math.pow(j, 2);
                    if (dp[i][m - arr[i]] == -1) {
                        dp[i][m - arr[i]] = tmpSum;
                    } else {
                        dp[i][m - arr[i]] = Math.min(dp[i][m - arr[i]], tmpSum);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= m; i++) {
            if (dp[n][i] != -1) {
                min = Math.min(min, dp[n][i]);
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        new Main2().solution();
    }
}
