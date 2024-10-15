package main.java.algolab.QuicksortHoare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {
    int hoareSwapCount;
    int hoareComparisonCount;
    int lomutoSwapCount;
    int lomutoComparisonCount;

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
            hoareSwapCount = 0;
            hoareComparisonCount = 0;
            lomutoSwapCount = 0;
            lomutoComparisonCount = 0;

            quicksortHoare(Arrays.copyOf(arr, n), 0, n - 1);
            quicksortLomuto(Arrays.copyOf(arr, n), 0, n - 1);

            sb.append(hoareSwapCount).append(" ");
            sb.append(lomutoSwapCount).append(" ");
            sb.append(hoareComparisonCount).append(" ");
            sb.append(lomutoComparisonCount).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private void quicksortHoare(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = partitionHoare(arr, low, high);
        quicksortHoare(arr, low, pivot);
        quicksortHoare(arr, pivot + 1, high);
    }

    private void quicksortLomuto(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = partitionLomuto(arr, low, high);
        quicksortLomuto(arr, low, pivot - 1);
        quicksortLomuto(arr, pivot + 1, high);
    }

    private int partitionHoare(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
                hoareComparisonCount++;
            } while (arr[i] < pivot);
            do {
                j--;
                hoareComparisonCount++;
            } while (arr[j] > pivot);
            if (i < j) {
                hoareSwapCount++;
                swap(arr, i, j);
                continue;
            }
            return j;
        }
    }

    private int partitionLomuto(int[] arr, int low, int high) {
        int pivot = arr[low];
        int j = low;
        for (int i = j + 1; i <= high; i++) {
            lomutoComparisonCount++;
            if (arr[i] < pivot) {
                j++;
                lomutoSwapCount++;
                swap(arr, j, i);
            }
        }
        int pivotPos = j;
        lomutoSwapCount++;
        swap(arr, low, pivotPos);
        return pivotPos;
    }

    private void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
