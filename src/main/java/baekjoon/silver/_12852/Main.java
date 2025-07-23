package main.java.baekjoon.silver._12852;

import java.io.*;
import java.util.*;

public class Main {

    Node answerNode = null;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = process(n);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n").append(answerNode.history);
        System.out.println(sb);
    }

    private int process(int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(n, "" + n));
        int count = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (node.num == 1) {
                    answerNode = node;
                    return count;
                }
                if (node.num % 3 == 0 && !visited[node.num / 3]) {
                    int tmp = node.num / 3;
                    visited[tmp] = true;
                    queue.offerLast(new Node(tmp, node.history + " " + tmp));
                }
                if (node.num % 2 == 0 && !visited[node.num / 2]) {
                    int tmp = node.num / 2;
                    visited[tmp] = true;
                    queue.offerLast(new Node(tmp, node.history + " " + tmp));
                }
                if (!visited[node.num - 1]) {
                    int tmp = node.num - 1;
                    visited[tmp] = true;
                    queue.offerLast(new Node(tmp, node.history + " " + tmp));
                }
            }
            count++;
        }
        return -1;
    }

    private class Node {
        int num;
        String history;
        public Node(int num, String history) {
            this.num = num;
            this.history = history;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
