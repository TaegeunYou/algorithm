package main.java.baekjoon.silver._2660;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }
            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            map.put(a, aList);
            List<Integer> bList = map.getOrDefault(b, new ArrayList<>());
            bList.add(a);
            map.put(b, bList);
        }
        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int score = -1;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offerLast(i);
            boolean[] visited = new boolean[n + 1];
            while (!queue.isEmpty()) {
                boolean flag = false;
                int len = queue.size();
                for (int j = 0; j < len; j++) {
                    int tmp = queue.pollFirst();
                    if (visited[tmp]) {
                        continue;
                    }
                    visited[tmp] = true;
                    flag = true;
                    if (map.get(tmp) != null) {
                        for (int next : map.get(tmp)) {
                            if (visited[next]) {
                                continue;
                            }
                            queue.offerLast(next);
                        }
                    }
                }
                if (flag) {
                    score++;
                }
            }
            scores[i] = score;
        }
        int minScore = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            minScore = Math.min(minScore, scores[i]);
        }
        StringBuilder candidate = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                count++;
                candidate.append(i).append(" ");
            }
        }
        candidate.deleteCharAt(candidate.length() - 1);
        System.out.println(minScore + " " + count);
        System.out.println(candidate);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
