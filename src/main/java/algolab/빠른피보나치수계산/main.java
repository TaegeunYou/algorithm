package main.java.algolab.빠른피보나치수계산;

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] result = getPow(new int[][]{new int[]{1,1}, new int[]{1, 0}}, n);
            sb.append(result[0][1]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int[][] matrix_mul(int[][] a, int[][] b) {
        int[][] result = new int[b[0].length][a.length];
        for (int i = 0; i < b[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += (a[i][k] * b[k][j]);
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = result[i][j] % 1000;
            }
        }
        return result;
    }

    private int[][] getPow(int[][] arr, int n) {
        if (n == 0) return new int[][]{new int[]{1, 0}, new int[]{0, 1}};
        if (n == 1) return arr;

        int[][] half = getPow(arr, n / 2);
        half = matrix_mul(half, half);

        if (n % 2 == 1) {
            half = matrix_mul(half, arr);
        }

        return half;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}