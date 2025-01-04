package main.java.baekjoon.silver._1283;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int idx = execute(list, str);
            if (idx == -1) {
                sb.append(str).append("\n");
                continue;
            }
            list.add(Character.toUpperCase(str.charAt(idx)));
            for (int j = 0; j < str.length(); j++) {
                char tmp = str.charAt(j);
                if (j == idx) {
                    sb.append("[").append(tmp).append("]");
                    continue;
                }
                sb.append(tmp);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int execute(List<Character> list, String str) {
        char[] arr = str.toCharArray();
        //조건 1
        for (int i = 0; i < str.length(); i++) {
            char tmp = Character.toUpperCase(arr[i]);
            if (i == 0 && !list.contains(tmp)) {
                return i;
            }
            if (i > 0 && arr[i - 1] == ' ' && !list.contains(tmp)) {
                return i;
            }
        }
        //조건 2
        for (int i = 0; i < str.length(); i++) {
            char tmp = Character.toUpperCase(arr[i]);
            if (tmp == ' ') {
                continue;
            }
            if (!list.contains(tmp)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
