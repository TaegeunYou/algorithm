package main.java.baekjoon.gold._1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            list.add(new Node(tmp));
        }
        int result = execute(list);
        System.out.println(result);
    }

    private int execute(List<Node> nodes) {
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                int sum = nodes.get(i).num + nodes.get(j).num;
                List<Pair> pairs = map.getOrDefault(sum, new ArrayList<>());
                pairs.add(new Pair(nodes.get(i), nodes.get(j)));
                map.put(sum, pairs);
            }
        }
        int result = 0;
        for (Node node : nodes) {
            List<Pair> pairs = map.get(node.num);
            if (pairs == null) {
                continue;
            }
            for (Pair pair : pairs) {
                if (node != pair.node1 && node != pair.node2) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    private class Node {
        int num;

        public Node(int num) {
            this.num = num;
        }
    }

    private class Pair {
        Node node1;
        Node node2;

        public Pair(Node node1, Node node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
