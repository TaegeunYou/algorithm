package main.java.programmers.level2.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] arr : road) {
            int start = arr[0];
            int end = arr[1];
            int cost = arr[2];
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }
        int[] dis = new int[N + 1];
        int[] ch = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if (ch[tmp.dest] == 0) {
                ch[tmp.dest] = 1;
                for (Node node : graph.get(tmp.dest)) {
                    if (dis[node.dest] > tmp.cost + node.cost) {
                        dis[node.dest] = tmp.cost + node.cost;
                        queue.offer(new Node(node.dest, tmp.cost + node.cost));
                    }
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dis[i] <= K) answer++;
        }
        return answer;
    }

    class Node implements Comparable<Node> {
        int dest;
        int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}