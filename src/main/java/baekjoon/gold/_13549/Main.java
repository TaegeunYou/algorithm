package main.java.baekjoon.gold._13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = bfs(n, k);
        System.out.println(result);
    }

    private int bfs(int n, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        multi(queue, n, visited);
        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int poll = queue.pollFirst();
                if (poll == k) {
                    return time;
                }
                multi(queue, poll + 1, visited);
                multi(queue, poll - 1, visited);
            }
            time++;
        }
        return -1;
    }

    private void multi(Deque<Integer> queue, int num, boolean[] visited) {
        if (num < 0 || num > 100000) {
            return;
        }
        int tmp = num;
        while (tmp <= 100000) {
            if (visited[tmp]) {
                break;
            }
            queue.offerLast(tmp);
            visited[tmp] = true;
            tmp *= 2;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
