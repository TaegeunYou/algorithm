package main.java.baekjoon.gold._2170;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.add(new Node(x, y));
        }
        nodes.sort(Comparator.naturalOrder());
        int next = Integer.MIN_VALUE;
        int answer = 0;
        for (Node node : nodes) {
            if (node.y <= next) {
                continue;
            }
            if (node.x <= next) {
                answer += Math.abs(node.y - next);
            } else {
                answer += Math.abs(node.y - node.x);
            }
            next = node.y;
        }
        System.out.println(answer);
    }

    private class Node implements Comparable<Node> {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Node o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
