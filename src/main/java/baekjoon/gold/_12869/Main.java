package main.java.baekjoon.gold._12869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[][] seqs = {
        {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
    };

    private static final int MAX = 60;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        Arrays.fill(arr, 0);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = process(arr);
        System.out.println(result);
        br.close();
    }

    private int process(int[] arr) {
        int[][][] dp = new int[MAX + 1][MAX + 1][MAX + 1];
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++) {
                for (int k = 0; k <= MAX; k++) {
                    for (int[] seq : seqs) {
                        int a = Math.max(i - seq[0], 0);
                        int b = Math.max(j - seq[1], 0);
                        int c = Math.max(k - seq[2], 0);
                        if (a == 0 && b == 0 && c == 0) {
                            dp[i][j][k] = 1;
                            continue;
                        }
                        if (dp[i][j][k] == 0) {
                            dp[i][j][k] = dp[a][b][c] + 1;
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[a][b][c] + 1);
                    }
                }
            }
        }
        return dp[arr[0]][arr[1]][arr[2]];
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
