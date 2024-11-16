package main.java.algolab.연속행렬곱셈Recursion;

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
            int[] arr = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                int d = Integer.parseInt(st.nextToken());
                arr[j] = d;
            }
            int result = execute(1, n, arr);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int execute(int i, int j, int[] arr) {
        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tmp = execute(i, k, arr) + execute(k + 1, j, arr) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(min, tmp);
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}