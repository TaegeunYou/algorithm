package main.java.baekjoon.gold._2252;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[b]++;
            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            aList.add(b);
            map.put(a, aList);
        }
        List<Integer> starts = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                starts.add(i);
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int start : starts) {
            queue.offerLast(start);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int num = queue.pollFirst();
            sb.append(num).append(" ");
            if (map.get(num) == null) {
                continue;
            }
            for (int i : map.get(num)) {
                arr[i]--;
                if (arr[i] == 0) {
                    queue.offerLast(i);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
