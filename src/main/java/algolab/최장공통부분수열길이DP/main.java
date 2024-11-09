package main.java.algolab.최장공통부분수열길이DP;

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
            String a = st.nextToken();
            String b = st.nextToken();
            String result = execute(a, b);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private String execute(String a, String b) {
        int[] aArr = initialArr(a);
        int[] bArr = initialArr(b);
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (aArr[i] == bArr[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a.length()][b.length()] + " " + findLcs(a, a.length() , b.length() , dp);
    }

    private int[] initialArr(String str) {
        int[] arr = new int[str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            arr[i] = str.charAt(i - 1);
        }
        return arr;
    }

    private String findLcs(String a, int m, int n, int[][] dp) {
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while (i != 0 && j != 0) {
            if (dp[i][j] != dp[i-1][j] && dp[i][j] != dp[i][j-1]) {
                sb.insert(0, a.charAt(i-1));
                i--;
                j--;
                continue;
            }
            if (dp[i][j] != dp[i][j-1]) {
                i--;
                continue;
            }
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}