package main.java.baekjoon.gold._1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayList<Edge>> map = new HashMap();
        for (int i = 1; i <= v; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int value = Integer.parseInt(st1.nextToken());
            map.get(a).add(new Edge(b, value));
            map.get(b).add(new Edge(a, value));
        }
        int result = process(v, e, map);
        System.out.println(result);
        br.close();
    }

    private int process(int v, int e, Map<Integer, ArrayList<Edge>> map) {
        int result = 0;
        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (Edge edge : map.get(1)) {
            queue.offer(edge);
        }
        visited[1] = true;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (visited[edge.dest]) {
                continue;
            }
            visited[edge.dest] = true;
            result += edge.value;
            for (Edge tmp : map.get(edge.dest)) {
                if (visited[tmp.dest]) {
                    continue;
                }
                queue.offer(tmp);
            }
        }
        return result;
    }

    private class Edge implements Comparable<Edge> {
        int dest;
        int value;

        public Edge(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
