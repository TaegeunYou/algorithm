package main.java.baekjoon.gold._1005;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n + 1];
            int[] countArr = new int[n + 1];
            int[] maxArr = new int[n + 1];
            Map<Integer, List<Integer>> map = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                maxArr[j] = arr[j];
            }
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int origin = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                countArr[dest]++;
                List<Integer> dests = map.getOrDefault(origin, new ArrayList<>());
                dests.add(dest);
                map.put(origin, dests);
            }
            int w = Integer.parseInt(br.readLine());
            List<Integer> starts = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (countArr[j] == 0) {
                    starts.add(j);
                }
            }
            Deque<Node> queue = new ArrayDeque<>();
            for (int start : starts) {
                queue.offerLast(new Node(start, arr[start]));
            }
            while (!queue.isEmpty()) {
                Node node = queue.pollFirst();
                if (map.get(node.num) == null) {
                    continue;
                }
                for (int tmp : map.get(node.num)) {
                    int tmpSum = node.sum + arr[tmp];
                    maxArr[tmp] = Math.max(maxArr[tmp], tmpSum);
                    countArr[tmp]--;
                    if (countArr[tmp] == 0) {
                        queue.offerLast(new Node(tmp, maxArr[tmp]));
                    }
                }
            }
            sb.append(maxArr[w]).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private class Node {
        int num;
        int sum;
        public Node(int num, int sum) {
            this.num = num;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
