package main.java.baekjoon.gold._7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    char[] separators = {' ', '+', '-'};
    StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            execute(n);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 2);
        System.out.println(sb);
    }

    private void execute(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        String str = sb.toString();
        dfs(1, str, n);
    }

    private void dfs(int idx, String str, int n) {
        if (idx >= str.length()) {
            if (check(str)) {
                sb.append(str).append("\n");
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            StringBuilder tmpSb = new StringBuilder(str);
            String tmpStr = tmpSb.replace(idx, idx + 1, Character.toString(separators[i])).toString();
            dfs(idx + 2, tmpStr, n);
        }
    }

    private boolean check(String str) {
        int sum = 0;
        int tmp = 0;
        Character operator = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                if (operator == null || operator == '+') {
                    sum += tmp;
                } else {
                    sum -= tmp;
                }
                tmp = 0;
                operator = c;
                continue;
            }
            if (c == ' ') {
                tmp *= 10;
                continue;
            }
            tmp += ((int) c - '0');
        }
        if (operator == null || operator == '+') {
            sum += tmp;
        } else {
            sum -= tmp;
        }
        return sum == 0;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
