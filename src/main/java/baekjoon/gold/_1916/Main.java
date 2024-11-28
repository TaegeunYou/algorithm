package main.java.baekjoon.gold._1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        Map<Integer, ArrayList<Edge>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.get(a).add(new Edge(b, value));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int origin = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        int result = process(origin, dest, n, map);
        System.out.println(result);
        br.close();
    }

    private int process(int origin, int dest, int n, Map<Integer, ArrayList<Edge>> map) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origin] = 0;

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(origin, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (visited[edge.dest]) {
                continue;
            }
            visited[edge.dest] = true;
            for (Edge tmp : map.get(edge.dest)) {
                if (visited[tmp.dest]) {
                    continue;
                }
                if (dist[tmp.dest] > edge.value + tmp.value) {
                    dist[tmp.dest] = edge.value + tmp.value;
                    queue.offer(new Edge(tmp.dest, dist[tmp.dest]));
                }
            }
        }
        return dist[dest];
    }

    private class Edge implements Comparable<Edge> {
        int dest;
        int value;

        public Edge(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }

        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
