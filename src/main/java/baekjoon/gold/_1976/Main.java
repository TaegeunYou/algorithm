package main.java.baekjoon.gold._1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = initial(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j, arr);
                }
            }
        }
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] travelArr = new int[m];
        for (int i = 0; i < m; i++) {
            travelArr[i] = Integer.parseInt(st1.nextToken()) - 1;
        }
        for (int i = 0; i < travelArr.length - 1; i++) {
            if (find(travelArr[i], arr) != find(travelArr[i + 1], arr)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private int[] initial(int n) {
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private int find(int n, int[] arr) {
        if (n == arr[n]) {
            return n;
        }
        return arr[n] = find(arr[n], arr);
    }

    private void union(int a, int b, int[] arr) {
        int pa = find(a, arr);
        int pb = find(b, arr);
        if (pa == pb) {
            return;
        }
        arr[pa] = pb;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
