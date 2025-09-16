package main.java.baekjoon.silver._1260;

import java.io.*;
import java.util.*;

public class Main {

    StringBuilder dfsSb = new StringBuilder();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            List<Integer> bList = map.getOrDefault(b, new ArrayList<>());
            aList.add(b);
            bList.add(a);
            map.put(a, aList);
            map.put(b, bList);
        }
        for (int i : map.keySet()) {
            List<Integer> list = map.get(i);
            list.sort(Comparator.naturalOrder());
        }
        boolean[] dfsVisited = new boolean[n + 1];
        dfs(v, map, dfsVisited);
        dfsSb.deleteCharAt(dfsSb.length() - 1);
        String resultBfs = bfs(v, n, map);
        System.out.println(dfsSb);
        System.out.println(resultBfs);

    }

    private String bfs(int start, int n, Map<Integer, List<Integer>> map) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(start);
        boolean[] visited = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int tmp = queue.pollFirst();
            if (visited[tmp]) {
                continue;
            }
            visited[tmp] = true;
            sb.append(tmp).append(" ");
            if (map.get(tmp) != null) {
                List<Integer> tmpList = map.get(tmp);
                for (int i : tmpList) {
                    if (visited[i]) {
                        continue;
                    }
                    queue.offerLast(i);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void dfs(int tmp, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[tmp]) {
            return;
        }
        visited[tmp] = true;
        dfsSb.append(tmp).append(" ");
        if (map.get(tmp) == null) {
            return;
        }
        for (int i : map.get(tmp)) {
            dfs(i, map, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
