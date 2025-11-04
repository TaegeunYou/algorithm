package main.java.baekjoon.gold._9205;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeX = Integer.parseInt(st.nextToken());
            int homeY = Integer.parseInt(st.nextToken());
            List<Node> nodes = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int storeX = Integer.parseInt(st.nextToken());
                int storeY = Integer.parseInt(st.nextToken());
                nodes.add(new Node(j, storeX, storeY, false));
            }
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            nodes.add(new Node(n + 1, targetX, targetY, true));
            boolean success = process(homeX, homeY, nodes);
            if (success) {
                sb.append("happy");
            } else {
                sb.append("sad");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private boolean process(int homeX, int homeY, List<Node> nodes) {
        boolean[] visited = new boolean[nodes.size() + 1];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(0, homeX, homeY, false));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (node.isTarget) {
                return true;
            }
            for (Node tmp : nodes) {
                if (visited[tmp.id]) {
                    continue;
                }
                int diffX = Math.abs(node.x - tmp.x);
                int diffY = Math.abs(node.y - tmp.y);
                int diff = diffX + diffY;
                if (diff <= 1000) {
                    visited[tmp.id] = true;
                    queue.offerLast(tmp);
                }
            }
        }
        return false;
    }

    private class Node {
        int id;
        int x;
        int y;
        boolean isTarget;
        public Node(int id, int x, int y, boolean isTarget) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.isTarget = isTarget;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
