package main.java.algolab.팩토리얼계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            BigInteger result = factorial(n);
            String resultStr = formatting(result);
            sb.append(resultStr).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private BigInteger factorial(int n) {
        if (n == 0) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    private String formatting(BigInteger n) {
        String str = n.toString().replaceAll("0+$", "");
        return str.length() > 3 ? str.substring(str.length() - 3) : str;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}