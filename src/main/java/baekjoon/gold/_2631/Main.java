package main.java.baekjoon.gold._2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(n, arr);
        System.out.println(result);
    }

    private int execute(int n, int[] arr) {
//        int lisLength = lisBs(arr);
        int lisLength = lisDp(arr);
        return n - lisLength;
    }

    private int lisDp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private int lisBs(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (list.isEmpty() || list.get(list.size() - 1) <= i) {
                list.add(i);
                continue;
            }
            int idx = lisBsFind(i, list);
            list.remove(idx);
            list.add(idx, i);
        }
        return list.size();
    }

    private int lisBsFind(int i, List<Integer> list) {
        int lt = 0;
        int rt = list.size() - 1;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (list.get(mid) < i) {
                lt = mid + 1;
                continue;
            }
            rt = mid;
        }
        return rt;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
