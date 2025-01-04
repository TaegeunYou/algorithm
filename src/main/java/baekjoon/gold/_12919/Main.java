package main.java.baekjoon.gold._12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int result = execute(s, t);
        System.out.println(result);
    }

    private int execute(String s, String t) {
        Deque<String> queue = new ArrayDeque<>();
        queue.offerLast(t);
        while (!queue.isEmpty()) {
            int len = queue.size();
            if (queue.peek().length() < s.length()) {
                return 0;
            }
            for (int i = 0; i < len; i++) {
                String str = queue.pollLast();
                if (str.equals(s)) {
                    return 1;
                }
                if (str.length() > 1 && str.charAt(str.length() - 1) == 'A') {
                    String newStr = str.substring(0, str.length() - 1);
                    if (!queue.contains(newStr)) {
                        queue.offerLast(newStr);
                    }
                }
                if (str.length() > 1 && str.charAt(0) == 'B') {
                    String newStr = new StringBuilder(str.substring(1)).reverse().toString();
                    if (!queue.contains(newStr)) {
                        queue.offerLast(newStr);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
