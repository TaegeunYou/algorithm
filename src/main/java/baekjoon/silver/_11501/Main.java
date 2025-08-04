package main.java.baekjoon.silver._11501;

import java.io.*;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long result = execute(n, arr);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private long execute(int n, int[] arr) {
        boolean[] buy = new boolean[n];
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                continue;
            }
            buy[i] = true;
        }
        List<Integer> buys = new ArrayList<>();
        long answer = 0;
        for (int i = 0; i < n; i++) {
            if (buy[i]) {
                buys.add(arr[i]);
                continue;
            }
            for (int tmp : buys) {
                answer += (arr[i] - tmp);
            }
            buys.clear();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
