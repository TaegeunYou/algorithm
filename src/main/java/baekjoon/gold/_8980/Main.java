package main.java.baekjoon.gold._8980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end, box));
        }
        nodes.sort(Comparator.naturalOrder());
        int answer = 0;
        int[] board = new int[n + 1];
        for (Node node : nodes) {
            int maxAvail = node.box;
            for (int i = node.start; i < node.end; i++) {
                int remain = c - board[i];
                maxAvail = Math.min(maxAvail, remain);
            }
            for (int i = node.start; i < node.end; i++) {
                board[i] += maxAvail;
            }
            answer += maxAvail;
        }
        System.out.println(answer);
    }

    private class Node implements Comparable<Node> {
        int start;
        int end;
        int box;
        public Node(int start, int end, int box) {
            this.start = start;
            this.end = end;
            this.box = box;
        }
        public int compareTo(Node o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
