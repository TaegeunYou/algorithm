package main.java.baekjoon.gold._1043;

import java.io.*;
import java.util.*;

public class Main {

    int[] arr;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        List<Integer> knows = new ArrayList<>();
        for (int i = 0; i < know; i++) {
            int num = Integer.parseInt(st.nextToken());
            knows.add(num);
        }
        if (knows.isEmpty()) {
            System.out.println(m);
            return;
        }
        arr = initial(n);
        if (knows.size() > 1) {
            int first = knows.get(0);
            for (int j = 1; j < knows.size(); j++) {
                union(first, knows.get(j));
            }
        }
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> joins = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                int num = Integer.parseInt(st.nextToken());
                joins.add(num);
            }
            parties.add(joins);
            if (joins.size() < 2) {
                continue;
            }
            int first = joins.get(0);
            for (int j = 1; j < joins.size(); j++) {
                union(first, joins.get(j));
            }
        }
        int q = find(knows.get(0));
        List<Integer> finalKnows = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (find(i) == q) {
                finalKnows.add(i);
            }
        }
        int answer = 0;
        for (List<Integer> party : parties) {
            boolean flag = true;
            for (int i : party) {
                if (finalKnows.contains(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        arr[pa] = pb;
    }

    private int find(int num) {
        if (arr[num] == num) {
            return num;
        }
        return arr[num] = find(arr[num]);
    }

    private int[] initial(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
