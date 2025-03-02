package main.java.programmers.level3.등산코스_정하기;

import java.util.*;

class Solution {

    Map<Integer, List<Edge>> map;
    int[] summits;
    boolean[] recordSummits;
    int n;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        this.n = n;
        this.recordSummits = new boolean[n + 1];
        for (int i : summits) {
            this.recordSummits[i] = true;
        }
        this.map = new HashMap<>();
        this.summits = summits;
        for (int[] arr : paths) {
            int a = arr[0];
            int b = arr[1];
            int cost = arr[2];
            List<Edge> edgesA = map.getOrDefault(a, new ArrayList<>());
            List<Edge> edgesB = map.getOrDefault(b, new ArrayList<>());
            edgesA.add(new Edge(b, cost));
            edgesB.add(new Edge(a, cost));
            map.put(a, edgesA);
            map.put(b, edgesB);
        }
        int minIntensity = Integer.MAX_VALUE;
        List<Integer> minSummits = new ArrayList<>();
        for (int gate : gates) {
            int[] arr = execute(gate, minIntensity);
            int summit = arr[0];
            int intensity = arr[1];
            if (minIntensity > intensity) {
                minSummits.clear();
                minIntensity = intensity;
                minSummits.add(summit);
            } else if (minIntensity == intensity) {
                minSummits.add(summit);
            }
        }
        minSummits.sort(Comparator.naturalOrder());
        Integer minSummit = minSummits.get(0);
        return new int[]{minSummit, minIntensity};
    }

    private int[] execute(int gate, int minIntensity) {
        int maxIntensity = 1;
        int minSummit = Integer.MAX_VALUE;
        boolean flag = false;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(gate, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (flag && edge.cost > maxIntensity) {
                break;
            }
            if (visited[edge.dest]) {
                continue;
            }
            if (edge.cost > minIntensity) {
                return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            }
            visited[edge.dest] = true;
            maxIntensity = Math.max(maxIntensity, edge.cost);
            if (recordSummits[edge.dest]) {
                minSummit = Math.min(minSummit, edge.dest);
                flag = true;
                continue;
            }
            for (Edge tmp : map.get(edge.dest)) {
                if (!visited[tmp.dest]) {
                    pq.offer(tmp);
                }
            }
        }
        return new int[]{minSummit, maxIntensity};
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
}
