package main.java.inflearn.Greedy;

import java.util.*;

/**
 * 6
 * 50 2
 * 20 1
 * 40 2
 * 60 3
 * 30 3
 * 30 1
 */
class Main0904 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Lecture[] arr = new Lecture[n];
        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int money = in.nextInt();
            int day = in.nextInt();
            arr[i] = new Lecture(money, day);
            maxDay = Math.max(maxDay, day);
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr[j].day != i) break;
                queue.offer(arr[j].money);
            }
            if (!queue.isEmpty()) answer += queue.poll();
        }
        System.out.println(answer);
    }

    public static class Lecture implements Comparable<Lecture> {
        int money;
        int day;

        public Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }
    }

}