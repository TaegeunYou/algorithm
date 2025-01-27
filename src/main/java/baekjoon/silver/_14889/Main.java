package main.java.baekjoon.silver._14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    int n;
    int[][] arr;
    List<Integer> list = new ArrayList<>();
    int answer = Integer.MAX_VALUE;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private void dfs(int idx) {
        if (idx == n || list.size() > n / 2) {
            return;
        }
        if (list.size() == n / 2) {
            int result = diff();
            answer = Math.min(answer, result);
        }
        dfs(idx + 1);
        list.add(idx);
        dfs(idx + 1);
        list.remove(list.size() - 1);
    }

    private int diff() {
        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!list.contains(i)) {
                remain.add(i);
            }
        }
        int sumA = calculate(list);
        int sumB = calculate(remain);
        return Math.abs(sumA - sumB);
    }

    private int calculate(List<Integer> nodes) {
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (i == j) {
                    continue;
                }
                int tmpA = nodes.get(i);
                int tmpB = nodes.get(j);
                sum += arr[tmpA][tmpB];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
