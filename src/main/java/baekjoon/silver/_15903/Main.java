package main.java.baekjoon.silver._15903;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            long tmp = Integer.parseInt(st.nextToken());
            pq.offer(tmp);
        }
        int remainM = m;
        while (remainM > 0) {
            long a = pq.poll();
            long b = pq.poll();
            long sum = a + b;
            pq.offer(sum);
            pq.offer(sum);
            remainM--;
        }
        long answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
