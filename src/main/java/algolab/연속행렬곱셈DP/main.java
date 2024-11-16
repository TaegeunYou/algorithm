package main.java.algolab.연속행렬곱셈DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int[][] dp = new int[n + 1][n + 1];
            int valueResult = minmult(n, arr, dp);
            order(1, n, dp, sb);
            sb.append("\n").append(valueResult).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int minmult(int n, int[] d, int[][] P) {
        int[][] M = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            M[i][i] = 0;
        }
        for (int diagonal = 1; diagonal <= n - 1; diagonal++) {
            for (int i = 1; i <= n - diagonal; i++) {
                int j = i + diagonal;
                int min = Integer.MAX_VALUE;
                int minK = -1;
                for (int k = i; k < j; k++) {
                    int tmp = M[i][k] + M[k + 1][j] + d[i - 1] * d[k] * d[j];
                    if (tmp < min) {
                        min = tmp;
                        minK = k;
                    }
                }
                M[i][j] = min;
                P[i][j] = minK;
            }
        }
        return M[1][n];
    }

    private void order(int i, int j, int[][] P, StringBuilder sb) {
        if (i == j) {
            sb.append("M").append(i);
        } else {
            int k = P[i][j];
            sb.append("(");
            order(i, k, P, sb);
            order(k + 1, j, P, sb);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}