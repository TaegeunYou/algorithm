package main.java.baekjoon.gold._1504;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    Map<Integer, List<Node>> map = new HashMap<>();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        //1 -> v1 -> v2 -> n
        //1 -> v2 -> v1 -> n
        //v1은 1일수 있고 v2는 n일수 있다.
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            List<Node> aNodes = map.getOrDefault(a, new ArrayList<>());
            List<Node> bNodes = map.getOrDefault(b, new ArrayList<>());
            aNodes.add(new Node(b, c));
            bNodes.add(new Node(a, c));
            map.put(a, aNodes);
            map.put(b, bNodes);
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        //answer1
        int answer1Tmp1 = dist(1, v1);
        int answer1Tmp2 = dist(v1, v2);
        int answer1Tmp3 = dist(v2, n);
        int answer1 = answer1Tmp1 + answer1Tmp2 + answer1Tmp3;
        if (answer1Tmp1 == -1 || answer1Tmp2 == -1 || answer1Tmp3 == -1) {
            answer1 = -1;
        }
        //answer2
        int answer2Tmp1 = dist(1, v2);
        int answer2Tmp2 = dist(v2, v1);
        int answer2Tmp3 = dist(v1, n);
        int answer2 = answer2Tmp1 + answer2Tmp2 + answer2Tmp3;
        if (answer2Tmp1 == -1 || answer2Tmp2 == -1 || answer2Tmp3 == -1) {
            answer2 = -1;
        }
        int answer = Math.min(answer1, answer2);
        System.out.println(answer);
    }

    private int dist(int a, int b) {
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(a, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.dest]) {
                continue;
            }
            if (node.dest == b) {
                return node.cost;
            }
            visited[node.dest] = true;
            if (map.get(node.dest) == null) {
                continue;
            }
            for (Node tmp : map.get(node.dest)) {
                if (visited[tmp.dest]) {
                    continue;
                }
                pq.offer(new Node(tmp.dest, tmp.cost + node.cost));
            }
        }
        return -1;
    }

    private class Node implements Comparable<Node> {
        int dest;
        int cost;
        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
