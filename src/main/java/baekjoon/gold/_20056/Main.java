package main.java.baekjoon.gold._20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            int m = Integer.parseInt(st2.nextToken());
            int s = Integer.parseInt(st2.nextToken());
            int d = Integer.parseInt(st2.nextToken());
            List<Node> list = new ArrayList<>();
            list.add(new Node(m, s, d));
            map.put(r + "-" + c, list);
        }
        for (int i = 0; i < k; i++) {
            exeucte(N, map);
        }
        int answer = 0;
        for (String key : map.keySet()) {
            List<Node> nodes = map.get(key);
            for (Node node : nodes) {
                answer += node.m;
            }
        }
        System.out.println(answer);
    }

    private void exeucte(int n, Map<String, List<Node>> map) {
        Map<String, List<Node>> tmpMap = new HashMap<>();
        for (String key : map.keySet()) {
            List<Node> nodes = map.get(key);
            String[] split = key.split("-");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            for (Node node : nodes) {
                int nx = (x + dx[node.d] * node.s + n * 250) % n;
                int ny = (y + dy[node.d] * node.s + n * 250) % n;
                String newKey = nx + "-" + ny;
                List<Node> list = tmpMap.getOrDefault(newKey, new ArrayList<>());
                list.add(node);
                tmpMap.put(newKey, list);
            }
        }
        map.clear();
        for (String key : tmpMap.keySet()) {
            List<Node> nodes = tmpMap.get(key);
            if (nodes.size() < 2) {
                map.put(key, nodes);
                continue;
            }
            int sumM = 0;
            int sumS = 0;
            int count = nodes.size();
            boolean isAllOdd = true;
            boolean isAllEven = true;
            for (Node node : nodes) {
                sumM += node.m;
                sumS += node.s;
                if (node.d % 2 == 0) {
                    isAllOdd = false;
                } else {
                    isAllEven = false;
                }
            }
            int sumMDivide = sumM / 5;
            if (sumMDivide == 0) {
                continue;
            }
            int sumSDivide = sumS / count;
            List<Node> list = new ArrayList<>();
            int idx = isAllOdd || isAllEven ? 0 : 1;
            for (; idx < dx.length; idx += 2) {
                list.add(new Node(sumMDivide, sumSDivide, idx));
            }
            map.put(key, list);
        }
    }

    private class Node {
        int m;
        int s;
        int d;

        public Node(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }



    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
