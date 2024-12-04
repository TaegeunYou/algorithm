package main.java.baekjoon.silver._1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }
        int result = execute(t, meetings);
        System.out.println(result);
    }

    private int execute(int t, ArrayList<Meeting> meetings) {
        Collections.sort(meetings);
        Meeting first = meetings.get(0);
        int count = 1;
        int time = first.end;
        for (int i = 1; i < meetings.size(); i++) {
            Meeting tmp = meetings.get(i);
            if (time <= tmp.start) {
                count++;
                time = tmp.end;
            }
        }
        return count;
    }

    private class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
