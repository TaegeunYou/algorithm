package main.java.algolab.ConnectedComponentDFSRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int node = Integer.parseInt(st.nextToken());
                int connect = Integer.parseInt(st.nextToken());
                map.put(node, new ArrayList<>());
                for (int k = 0; k < connect; k++) {
                    int connectNode = Integer.parseInt(st.nextToken());
                    map.get(node).add(connectNode);
                }
            }
            String result = process(n, map);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }

    private String process(int n, Map<Integer, ArrayList<Integer>> map) {
        boolean[] visited = new boolean[n + 1];
        int component = 0;
        ArrayList<Integer> connectNodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> tmpNodes = new ArrayList<>();
                tmpNodes.add(i);
                dfs(i, map, visited, tmpNodes);
                component++;
                connectNodes.add(tmpNodes.size());
            }
        }
        connectNodes.sort(Comparator.naturalOrder());
        return printResult(component, connectNodes);
    }

    private void dfs(int i, Map<Integer, ArrayList<Integer>> map, boolean[] visited, ArrayList<Integer> connectNodes) {
        visited[i] = true;
        for (int node : map.get(i)) {
            if (!visited[node]) {
                connectNodes.add(node);
                dfs(node, map, visited, connectNodes);
            }
        }
    }

    private String printResult(int component, ArrayList<Integer> connectNodes) {
        StringBuilder sb = new StringBuilder();
        sb.append(component).append(" ");
        for (int node : connectNodes) {
            sb.append(node).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}
