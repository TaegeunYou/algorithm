package main.java.inflearn.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 */
class Main0902 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(in.nextInt(), in.nextInt());
        }
        Arrays.sort(meetings);
        int end = Integer.MIN_VALUE;
        int cnt = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= end) {
                cnt++;
                end = meeting.end;
            }
        }
        System.out.println(cnt);
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end != o.end) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }

}