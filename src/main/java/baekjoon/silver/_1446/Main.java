package main.java.baekjoon.silver._1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road> roads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            int cost = Integer.parseInt(st1.nextToken());
            roads.add(new Road(start, end, cost));
        }
        int result = execute(roads, d);
        System.out.println(result);
    }

    private int execute(List<Road> roads, int d) {
        int[] dp = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dp[i] = i;
        }
        roads.sort(Comparator.naturalOrder());
        for (Road road : roads) {
            if (road.end > d) {
                continue;
            }
            int tmp = dp[road.start] + road.cost;
            if (tmp < dp[road.end]) {
                dp[road.end] = tmp;
                for (int i = road.end + 1; i <= d; i++) {
                    dp[i] = Math.min(dp[i], dp[i - 1] + 1);
                }
            }
        }
        return dp[d];
    }

    private class Road implements Comparable<Road> {
        int start;
        int end;
        int cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
