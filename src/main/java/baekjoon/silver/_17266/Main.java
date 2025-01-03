package main.java.baekjoon.silver._17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int maxHeight = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int distance = list.get(i + 1) - list.get(i);
            int height = (distance % 2 == 0) ? (distance / 2) : (distance / 2 + 1);
            maxHeight = Math.max(maxHeight, height);
        }
        maxHeight = Math.max(maxHeight, list.get(0));
        maxHeight = Math.max(maxHeight, n - list.get(list.size() - 1));
        System.out.println(maxHeight);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
