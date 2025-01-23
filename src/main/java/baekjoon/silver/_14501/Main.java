package main.java.baekjoon.silver._14501;

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
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(-1, -1));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(day, cost));
        }
        int result = execute(n, meetings);
        System.out.println(result);
    }

    private int execute(int n, List<Meeting> meetings) {
        int[] dp = new int[n + 1];
        for (int today = 1; today <= n; today++) {
            dp[today] = dp[today - 1];
            for (int j = 0; j < 5; j++) {
                int day = today - j;
                if (day < 1) {
                    break;
                }
                Meeting dayMeeting = meetings.get(day);
                if (day + dayMeeting.day == today + 1) {
                    dp[today] = Math.max(dp[today], dp[day - 1] + dayMeeting.cost);
                }
            }
        }
        return dp[n];
    }

    private class Meeting {
        int day;
        int cost;

        public Meeting(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
