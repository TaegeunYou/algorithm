package main.java.baekjoon.gold._11000;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end));
        }
        nodes.sort(Comparator.naturalOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Node node : nodes) {
            if (pq.isEmpty()) {
                pq.offer(node.end);
                continue;
            }
            if (pq.peek() <= node.start) {
                pq.poll();
                pq.offer(node.end);
                continue;
            }
            pq.offer(node.end);
        }
        System.out.println(pq.size());
    }

    private class Node implements Comparable<Node> {
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node o) {
            return this.start - o.start;
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
