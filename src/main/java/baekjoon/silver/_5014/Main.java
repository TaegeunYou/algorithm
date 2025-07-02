package main.java.baekjoon.silver._5014;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        String result = execute(F, S, G, U, D);
        System.out.println(result);
    }

    private String execute(int F, int S, int G, int U, int D) {
        boolean[] visited = new boolean[F + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(S);
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int tmp = queue.pollFirst();
                if (visited[tmp]) {
                    continue;
                }
                visited[tmp] = true;
                if (tmp == G) {
                    return String.valueOf(count);
                }
                int up = tmp + U;
                if (up <= F && !visited[up]) {
                    queue.offerLast(up);
                }
                int down = tmp - D;
                if (down >= 1 && !visited[down]) {
                    queue.offerLast(down);
                }
            }
        }
        return "use the stairs";
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
