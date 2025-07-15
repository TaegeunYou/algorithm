package main.java.baekjoon.gold._13913;

import java.io.*;
import java.util.*;

public class Main {

    boolean[] visited;
    Deque<Node> queue;

    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (n <= k) {
            Node node = execute(n, k);
            sb.append(node.time).append("\n").append(node.record);
        } else {
            sb.append(n - k).append("\n");
            for (int i = n; i >= k; i--) {
                sb.append(i).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }

    private Node execute(int n, int k) {
        visited = new boolean[100001];
        queue = new ArrayDeque<>();
        queue.offerLast(new Node(n, "" + n, 0));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (node.position == k) {
                return node;
            }
            if (visited[node.position]) {
                continue;
            }
            visited[node.position] = true;
            process(node.position - 1, node);
            process(node.position + 1, node);
            process(node.position * 2, node);
        }
        return null;
    }

    private void process(int position, Node beforeNode) {
        if (position < 0 || position > 100000) {
            return;
        }
        if (visited[position]) {
            return;
        }
        queue.offerLast(new Node(position, beforeNode.record + " " + position, beforeNode.time + 1));
    }

    public class Node {
        int position;
        String record;
        int time;

        public Node(int position, String record, int time) {
            this.position = position;
            this.record = record;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
