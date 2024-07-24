package main.java.inflearn.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 14 18
 * 12 15
 * 15 20
 * 20 30
 * 5 14
 */
class Main0903_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Time[] times = new Time[n * 2];
        for (int i = 0; i < n; i++) {
            times[i * 2] = new Time(in.nextInt(), 's');
            times[i * 2 + 1] = new Time(in.nextInt(), 'e');
        }
        Arrays.sort(times);
        int cnt = 0;
        int answer = Integer.MIN_VALUE;
        for (Time time : times) {
            if (time.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    static class Time implements Comparable<Time> {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) return this.state - o.state;
            return this.time - o.time;
        }
    }

}