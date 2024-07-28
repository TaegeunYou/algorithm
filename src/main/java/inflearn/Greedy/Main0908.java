package main.java.inflearn.Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 9 12
 * 1 2 12
 * 1 9 25
 * 2 3 10
 * 2 8 17
 * 2 9 8
 * 3 4 18
 * 3 7 55
 * 4 5 44
 * 5 6 60
 * 5 7 38
 * 7 8 35
 * 8 9 15
 */
class Main0908 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        int[] ch = new int[v + 1];
        ArrayList<ArrayList<Road>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        PriorityQueue<Road> queue = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Road(b, c));
            graph.get(b).add(new Road(a, c));
        }
        queue.offer(new Road(1, 0));
        int answer = 0;
        while (!queue.isEmpty()) {
            Road tmp = queue.poll();
            if (ch[tmp.v] == 0) {
                ch[tmp.v] = 1;
                answer += tmp.cost;
                for (Road road : graph.get(tmp.v)) {
                    if (ch[road.v] == 0) {
                        queue.offer(road);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Road implements Comparable<Road> {
        int v;
        int cost;

        public Road(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }


}