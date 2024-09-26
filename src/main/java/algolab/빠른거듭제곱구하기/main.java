package main.java.algolab.빠른거듭제곱구하기;

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
            int a = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int result = execute(a, n);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int execute(int a, int n) {
        if (n == 0) return 1;
        int result;
        if (n % 2 == 0) {
            result = (int) Math.pow(execute(a, n / 2), 2);
        } else {
            result = a * (int) Math.pow(execute(a, (n - 1) / 2), 2);
        }
        String str = Integer.toString(result);
        return Integer.parseInt(str.length() > 3 ? str.substring(str.length() - 3) : str);
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}