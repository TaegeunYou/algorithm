package main.java.algolab.최장공통부분수열길이Memoization;

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int[][] mem = initialArray(a.length() + 1, b.length() + 1);
            int result = lcs(a, b, mem);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int lcs(String a, String b, int[][] mem) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        if (m < 0 || n < 0) {
            return 0;
        }
        if (mem[m][n] != -1) {
            return mem[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            return mem[m][n] = getOrCreate(a, b, m - 1, n - 1, mem) + 1;
        }
        return mem[m][n] = Math.max(
            getOrCreate(a, b, m - 1, n, mem),
            getOrCreate(a, b, m, n - 1, mem)
        );
    }

    private int getOrCreate(String a, String b, int i, int j, int[][] mem) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        return mem[i][j] = lcs(substringToIdx(a, i), substringToIdx(b, j), mem);
    }

    private String substringToIdx(String str, int idx) {
        return str.substring(0, idx + 1);
    }

    private int[][] initialArray(int i, int j) {
        int[][] mem = new int[i][j];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return mem;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}