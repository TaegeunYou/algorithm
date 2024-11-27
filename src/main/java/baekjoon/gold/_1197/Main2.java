package main.java.baekjoon.gold._1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2 {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int value = Integer.parseInt(st1.nextToken());
            list.add(new Edge(a, b, value));
        }
        Collections.sort(list);
        int result = process(v, list);
        System.out.println(result);
        br.close();
    }

    private int process(int v, ArrayList<Edge> list) {
        int result = 0;
        int[] arr = initial(v);
        while (!list.isEmpty()) {
            Edge edge = list.remove(0);
            if (find(edge.a, arr) == find(edge.b, arr)) {
                continue;
            }
            result += edge.value;
            union(edge.a, edge.b, arr);
        }
        return result;
    }

    private int[] initial(int v) {
        int[] arr = new int[v + 1];
        for (int i = 1; i <= v; i++) {
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

    private void union(int i, int j, int[] arr) {
        int pi = find(i, arr);
        int pj = find(j, arr);
        arr[pi] = pj;
    }

    private class Edge implements Comparable<Edge> {
        int a;
        int b;
        int value;

        public Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }

        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main2().solution();
    }
}
