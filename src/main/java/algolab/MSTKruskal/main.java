package main.java.algolab.MSTKruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            int nodes = Integer.parseInt(br.readLine());
            for (int j = 0; j < nodes; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int connects = Integer.parseInt(st.nextToken());
                for (int k = 0; k < connects; k++) {
                    int b = Integer.parseInt(st.nextToken());
                    int dist = Integer.parseInt(st.nextToken());
                    queue.add(new Edge(a, b, dist));
                }
            }
            int result = kruskal(nodes, queue);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int kruskal(int nodes, PriorityQueue<Edge> queue) {
        int[] arr = initial(nodes);
        int sumEdges = 0;
        int countEdges = 0;
        while (countEdges < nodes - 1) {
            Edge edge = queue.poll();
            if (!isSameSet(edge.a, edge.b, arr)) {
                merge(edge.a, edge.b, arr);
                sumEdges += edge.dist;
                countEdges++;
            }
        }
        return sumEdges;
    }

    private int[] initial(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private int find(int i, int[] arr) {
        if (arr[i] == i) {
            return i;
        }
        return arr[i] = find(arr[i], arr);
    }

    private void merge(int i, int j, int[] arr) {
        int pi = find(i, arr);
        int pj = find(j, arr);
        if (pi != pj) {
            arr[pi] = pj;
        }
    }

    private boolean isSameSet(int i, int j, int[] arr) {
        int pi = find(i, arr);
        int pj = find(j, arr);
        return pi == pj;
    }

    private class Edge implements Comparable<Edge> {
        int a;
        int b;
        int dist;

        public Edge(int a, int b, int dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
