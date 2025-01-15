package main.java.baekjoon.gold._1238;

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
        int x = Integer.parseInt(st1.nextToken());
        Map<Integer, List<Edge>> map = new HashMap<>();
        Map<Integer, List<Edge>> reverseMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st2.nextToken());
            int dest = Integer.parseInt(st2.nextToken());
            int cost = Integer.parseInt(st2.nextToken());
            List<Edge> edges = map.getOrDefault(origin, new ArrayList<>());
            edges.add(new Edge(dest, cost));
            map.put(origin, edges);
            List<Edge> reverseEdges = reverseMap.getOrDefault(dest, new ArrayList<>());
            reverseEdges.add(new Edge(origin, cost));
            reverseMap.put(dest, reverseEdges);
        }
        int[] reverseArr = execute(n, x, reverseMap);
        int[] arr = execute(n, x, map);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] + reverseArr[i]);
        }
        System.out.println(max);
    }

    private int[] execute(int n, int x, Map<Integer, List<Edge>> map) {
        int[] result = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(x, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.dest]) {
                continue;
            }
            visited[edge.dest] = true;
            result[edge.dest] = edge.cost;
            for (Edge tmp : map.get(edge.dest)) {
                if (visited[tmp.dest]) {
                    continue;
                }
                pq.offer(new Edge(tmp.dest, edge.cost + tmp.cost));
            }
        }
        return result;
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
