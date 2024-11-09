package main.java.algolab.최장공통부분수열길이Recursion;

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
            int result = lcs(a, b);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int lcs(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        if (m < 0 || n < 0) {
            return 0;
        }
        if (a.charAt(m) == b.charAt(n)) {
            return lcs(substringToIdx(a, m - 1), substringToIdx(b, n - 1)) + 1;
        }
        return Math.max(
            lcs(substringToIdx(a, m - 1) ,substringToIdx(b, n)),
            lcs(substringToIdx(a, m) ,substringToIdx(b, n - 1))
        );
    }

    private String substringToIdx(String str, int idx) {
        return str.substring(0, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
