package main.java.algolab.연속행렬곱셈Memoization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                int d = Integer.parseInt(st.nextToken());
                arr[j] = d;
            }
            int[][] dp = initialArray(n + 1);
            int result = execute(1, n, arr, dp);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int execute(int i, int j, int[] arr, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tmp = execute(i, k, arr, dp) + execute(k + 1, j, arr, dp) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, tmp);
        }
        return dp[i][j] = min;
    }

    private int[][] initialArray(int size) {
        int[][] newArr = new int[size][size];
        for (int[] arr : newArr) {
            Arrays.fill(arr, - 1);
        }
        return newArr;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}