package main.java.inflearn.Greedy;

import java.util.Arrays;
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
class Main0907 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt();
        int e = in.nextInt();
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            unf[i] = i;
        }
        Road[] roads = new Road[e];
        for (int i = 0; i < e; i++) {
            roads[i] = new Road(in.nextInt(), in.nextInt(), in.nextInt());
        }
        Arrays.sort(roads);
        int answer = 0;
        for (Road road : roads) {
            int fv1 = find(road.v1);
            int fv2 = find(road.v2);
            if (fv1 != fv2) {
                answer += road.cost;
                union(road.v1, road.v2);
            }
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (unf[a] == a) return a;
        else return unf[a] = find(unf[a]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    static class Road implements Comparable<Road> {
        int v1;
        int v2;
        int cost;

        public Road(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }

}