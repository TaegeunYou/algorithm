package main.java.baekjoon.silver._11724;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            List<Integer> uList = map.getOrDefault(u, new ArrayList<>());
            List<Integer> vList = map.getOrDefault(v, new ArrayList<>());
            uList.add(v);
            vList.add(u);
            map.put(u, uList);
            map.put(v, vList);
        }
        int result = execute();
        System.out.println(result);
    }

    private int execute() {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            result++;
            bfs(i);
        }
        return result;
    }

    private void bfs(int i) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            int tmp = queue.pollFirst();
            if (visited[tmp]) {
                continue;
            }
            visited[tmp] = true;
            if (map.get(tmp) != null) {
                List<Integer> tmpList = map.get(tmp);
                for (int next : tmpList) {
                    if (visited[next]) {
                        continue;
                    }
                    queue.offerLast(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
