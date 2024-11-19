package main.java.baekjoon.gold._15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Consult> consults = new ArrayList<>();
        consults.add(new Consult(0, 0, 0));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            consults.add(new Consult(i + 1, a, b));
        }
        int result = execute(n, consults);
        System.out.println(result);
    }

    private int execute(int n, List<Consult> consults) {
        int[] dp = new int[n + 1];
        for (int day = 1; day <= n; day++) {
            Consult consult = consults.get(day);
            dp[day] = Math.max(dp[day], dp[day - 1]);
            if (day + consult.time - 1 > n) {
                continue;
            }
            dp[day + consult.time - 1] = Math.max(dp[day + consult.time - 1], dp[day - 1] + consult.price);
        }
        return dp[n];
    }

    private class Consult {
        int day;
        int time;
        int price;

        public Consult(int day, int time, int price) {
            this.day = day;
            this.time = time;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main1().solution();
    }
}
