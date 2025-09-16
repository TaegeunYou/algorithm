package main.java.baekjoon.silver._11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    boolean[] visited;
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<Integer> parents = new ArrayList<>();
    int[][] result;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int avail = Integer.parseInt(st.nextToken());
                if (avail == 1) {
                    List<Integer> iList = map.getOrDefault(i, new ArrayList<>());
                    iList.add(j);
                    map.put(i, iList);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void dfs(int tmp) {
        boolean flag = true;
        for (int parent : parents) {
            if (result[parent][tmp] == 0) {
                result[parent][tmp] = 1;
                flag = false;
            }
        }
        if (visited[tmp] && flag) {
            return;
        }
        visited[tmp] = true;
        if (map.get(tmp) == null) {
            return;
        }
        parents.add(tmp);
        for (int i : map.get(tmp)) {
            dfs(i);
        }
        parents.remove(parents.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
