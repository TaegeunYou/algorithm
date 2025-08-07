package main.java.baekjoon.gold._2461;

import java.io.*;
import java.util.*;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                nodes.add(new Node(num, i));
            }
        }
        nodes.sort(Comparator.naturalOrder());
        int result = execute(n, nodes);
        System.out.println(result);
    }

    private int execute(int n, List<Node> nodes) {
        int[] checkRoom = new int[n];
        int lt = 0;
        int rt = 0;
        Node start = nodes.get(rt);
        checkRoom[start.room] = 1;
        int remain = n - 1;
        int size = nodes.size();
        int answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            while (remain > 0 && rt < size - 1) {
                rt++;
                Node node = nodes.get(rt);
                if (checkRoom[node.room] == 0) {
                    remain--;
                }
                checkRoom[node.room]++;
            }
            if (remain == 0) {
                answer = Math.min(answer, nodes.get(rt).num - nodes.get(lt).num);
            }
            Node node = nodes.get(lt);
            checkRoom[node.room]--;
            if (checkRoom[node.room] == 0) {
                remain++;
            }
            lt++;
        }
        return answer;
    }

    private class Node implements Comparable<Node> {
        int num;
        int room;
        public Node(int num, int room) {
            this.num = num;
            this.room = room;
        }
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
