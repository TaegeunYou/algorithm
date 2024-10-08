package main.java.algolab.MergeSort;

import java.io.*;
import java.util.*;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int result = mergeSort(arr, 0, n - 1);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int mergeSort(int[] arr, int start, int end) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int a = mergeSort(arr, start, mid);
        int b = mergeSort(arr, mid + 1, end);
        int c = merge(arr, start, mid, end);
        return a + b + c;
    }

    private int merge(int[] arr, int start, int mid, int end) {
        int result = 0;
        int[] tmp = Arrays.copyOf(arr, arr.length);

        int i = start;
        int j = mid + 1;
        int idx = i;

        while (i <= mid && j <= end) {
            result++;
            if (tmp[i] <= tmp[j]) {
                arr[idx++] = tmp[i++];
            } else {
                arr[idx++] = tmp[j++];
            }
        }

        while (i <= mid) {
            arr[idx++] = tmp[i++];
        }
        while (j <= end) {
            arr[idx++] = tmp[j++];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}