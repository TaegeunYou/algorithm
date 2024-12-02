package main.java.baekjoon.gold._11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Matrix> list = new ArrayList<>();
        list.add(new Matrix(0, 0));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            list.add(new Matrix(row, col));
        }
        int result = execute(n, list);
        System.out.println(result);
        br.close();
    }

    private int execute(int n, ArrayList<Matrix> list) {
        int[][] dp = new int[n + 1][n + 1];
        for (int d = 1; d < n; d++) {
            for (int i = 1; i <= n - d; i++) {
                int j = i + d;
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int tmp = dp[i][k] + dp[k + 1][j] + list.get(i).row * list.get(k).col * list.get(j).col;
                    if (tmp < min) {
                        min = tmp;
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }

    private class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
