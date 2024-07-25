package main.java.inflearn.Greedy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 6 9
 * 1 2 12
 * 1 3 4
 * 2 1 2
 * 2 3 5
 * 2 5 5
 * 3 4 5
 * 4 2 2
 * 4 5 5
 * 6 4 5
 */
class Main0905 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(1, 0));
        dis[1] = 0;
        while (!queue.isEmpty()) {
            Edge tmp = queue.poll();
            for (Edge edge : graph.get(tmp.dest)) {
                if (dis[edge.dest] > tmp.cost + edge.cost) {
                    dis[edge.dest] = tmp.cost + edge.cost;
                    queue.offer(new Edge(edge.dest, tmp.cost + edge.cost));
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) System.out.println(i + " impossible");
            else System.out.println(i + " " + dis[i]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(@NotNull Edge o) {
            return this.cost - o.cost;
        }
    }

}