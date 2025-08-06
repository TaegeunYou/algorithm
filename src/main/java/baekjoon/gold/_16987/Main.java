package main.java.baekjoon.gold._16987;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    List<Node> nodes = new ArrayList<>();
    int answer = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes.add(new Node(s, w));
        }
        process(0, 0);
        System.out.println(answer);
    }

    private void process(int idx, int count) {
        answer = Math.max(answer, count);
        if (idx == n) {
            return;
        }
        Node node = nodes.get(idx);
        if (node.s <= 0) {
            process(idx + 1, count);
            return;
        }
        int nodeS = node.s;
        for (int i = 0; i < n; i++) {
            if (i == idx) {
                continue;
            }
            Node tmp = nodes.get(i);
            if (tmp.s <= 0) {
                continue;
            }
            int tmpS = tmp.s;
            node.s -= tmp.w;
            tmp.s -= node.w;
            int afterCount = count;
            if (node.s <= 0) {
                afterCount++;
            }
            if (tmp.s <= 0) {
                afterCount++;
            }
            process(idx + 1, afterCount);
            node.s = nodeS;
            tmp.s = tmpS;
        }
    }

    private class Node {
        int s;
        int w;
        public Node (int s, int w) {
            this.s = s;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
