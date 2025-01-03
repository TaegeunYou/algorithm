package main.java.baekjoon.silver._9017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        if (t == 0) {
            return;
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int m = Integer.parseInt(st.nextToken());
                list.add(m);
                map.put(m, map.getOrDefault(m, 0) + 1);
            }
            for (int key : map.keySet()) {
                if (map.get(key) < 6) {
                    list = list.stream().filter(it -> it != key).collect(Collectors.toList());
                }
            }
            int result = execute(list);
            System.out.println(result);
        }
    }

    private int execute(List<Integer> list) {
        int[] check = new int[201];
        int[] sum = new int[201];
        int[] fifth = new int[201];
        for (int i = 0; i < list.size(); i++) {
            int team = list.get(i);
            if (check[team] > 4) {
                continue;
            }
            if (check[team] == 4) {
                fifth[team] = i + 1;
                check[team]++;
                continue;
            }
            check[team]++;
            sum[team] += i + 1;
        }
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= 200; i++) {
            if (sum[i] == 0) {
                continue;
            }
            minScore = Math.min(minScore, sum[i]);
        }
        int minTeam = -1;
        for (int i = 1; i <= 200; i++) {
            if (sum[i] == 0) {
                continue;
            }
            if (minScore == sum[i]) {
                if (minTeam == -1 || fifth[minTeam] > fifth[i]) {
                    minTeam = i;
                }
            }
        }
        return minTeam;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
