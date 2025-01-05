package main.java.baekjoon.gold._16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Road> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            list.add(new Road(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())));
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            list.add(new Road(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken())));
        }
        int result = execute(list);
        System.out.println(result);
    }

    private int execute(List<Road> list) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(1);
        int seq = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.pollFirst();
                if (node == 100) {
                    return seq;
                }
                for (int j = 1; j <= 6; j++) {
                    boolean flag = true;
                    for (Road road : list) {
                        if (road.start == node + j) {
                            if (!queue.contains(road.end)) {
                                queue.offerLast(road.end);
                            }
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if (!queue.contains(node + j)) {
                            queue.offerLast(node + j);
                        }
                    }
                }
            }
            seq++;
        }
        return -1;
    }

    private class Road {
        int start;
        int end;

        public Road(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
