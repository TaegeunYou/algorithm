package main.java.algolab.MergeSortIterative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
            int result = mergeSortIterative(arr);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int mergeSortIterative(int[] arr) {
        int size = 1;
        int n = arr.length;
        int result = 0;
        while (size < n) {
            for (int i = 0; i < n; i += 2 * size) {
                int start = i;
                int mid = start + size - 1;
                int end = Math.min(i + 2 * size - 1, n - 1);
                if (mid >= n - 1) break;
                result += merge(arr, start, mid, end);
            }
            size *= 2;
        }
        return result;
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