package main.java.baekjoon.gold._9466;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int result = execute(n, arr);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int execute(int n, int[] arr)  {
        int total = 0;
        int[] check = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (check[i] > 0) {
                continue;
            }
            int tmp = i;
            List<Integer> members = new ArrayList<>();
            members.add(tmp);
            check[tmp] = i;
            boolean success = false;
            while (true) {
                tmp = arr[tmp];
                if (check[tmp] == i) {
                    success = true;
                    break;
                }
                if (check[tmp] > 0) {
                    break;
                }
                members.add(tmp);
                check[tmp] = i;
            }
            if (success) {
                int idx = members.indexOf(tmp);
                int count = members.size() - idx;
                total += count;
            }
        }
        return n - total;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
