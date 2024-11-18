package main.java.baekjoon.silver._2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    int[] arr;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        arr = new int[t + 3];
        for (int i = 0; i < t; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        int result = execute(t);
        System.out.println(result);
    }

    private int execute(int n) {
        List<List<Node>> list = new ArrayList<>();
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        list1.add(new Node(arr[1], 1));
        list2.add(new Node(arr[1] + arr[2], 2));
        list2.add(new Node(arr[2], 0));
        list.add(new ArrayList<>());
        list.add(list1);
        list.add(list2);

        for (int i = 3; i <= n; i++) {
            ArrayList<Node> tmpList = new ArrayList<>();
            int tmpNum = arr[i];

            Node node = list.get(i - 2).stream().max(Comparator.comparingInt(it -> it.sum)).get();
            List<Node> nodes = list.get(i - 1).stream()
                .filter(it -> it.oneStairSeq < 1)
                .map(it -> new Node(it.sum + tmpNum, it.oneStairSeq + 1))
                .collect(Collectors.toList());

            tmpList.add(new Node(node.sum + tmpNum, 0));
            tmpList.addAll(nodes);

            list.add(tmpList);
        }

        return list.get(n).stream().max(Comparator.comparingInt(it -> it.sum)).get().sum;
    }

    class Node {
        public int sum;
        public int oneStairSeq;

        public Node(int sum, int oneStairSeq) {
            this.sum = sum;
            this.oneStairSeq = oneStairSeq;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
