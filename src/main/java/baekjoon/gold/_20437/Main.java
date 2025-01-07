package main.java.baekjoon.gold._20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            String result = execute(str, k);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private String execute(String str, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 97; i <= 122; i++) {
            List<Integer> list = new ArrayList<>();
            char c = (char) i;
            for (int j = 0; j < str.length(); j++) {
                if (c == str.charAt(j)) {
                    list.add(j);
                }
            }
            for (int j = 0; j <= list.size() - k; j++) {
                int num = list.get(j + k - 1) - list.get(j) + 1;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
            return "-1";
        }
        return min + " " + max;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
