package main.java.baekjoon.gold._5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            List<Edge> listA = map.getOrDefault(a, new ArrayList<>());
            List<Edge> listB = map.getOrDefault(b, new ArrayList<>());
            listA.add(new Edge(b, cost));
            listB.add(new Edge(a, cost));
            map.put(a, listA);
            map.put(b, listB);
        }
        int result = execute(n, map);
        System.out.println(result);
    }

    private int execute(int n, Map<Integer, List<Edge>> map) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        queue.add(new Edge(1, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (visited[edge.dest]) {
                continue;
            }
            visited[edge.dest] = true;
            distance[edge.dest] = edge.cost;
            if (edge.dest == n) {
                break;
            }
            List<Edge> edges = map.get(edge.dest);
            if (edges == null) {
                continue;
            }
            for (Edge tmp : edges) {
                if (visited[tmp.dest]) {
                    continue;
                }
                queue.offer(new Edge(tmp.dest, tmp.cost + edge.cost));
            }
        }
        return distance[n];
    }

    private class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
