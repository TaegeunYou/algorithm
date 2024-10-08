package main.java.algolab.최대연속부분순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

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
            int result = recursive(arr, 0, n - 1);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int recursive(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        //중앙을 중심으로 왼쪽 구간의 최대 값
        int a = recursive(arr, start, mid);
        //중앙을 중심으로 오른쪽 구간의 최대 값
        int b = recursive(arr, mid + 1, end);
        //중앙을 걸치는 최대 값
        int c = getMidMax(arr, mid);
        return Stream.of(a, b, c).max(Comparator.naturalOrder()).get();
    }

    private int getMidMax(int[] arr, int mid) {
        int leftTotal = 0;
        int leftMax = 0;
        int rightTotal = 0;
        int rightMax = 0;
        for (int i = mid; i >= 0; i--) {
            leftTotal += arr[i];
            if (leftTotal < 0) break;
            leftMax = Math.max(leftMax, leftTotal);
        }
        for (int i = mid + 1; i < arr.length; i++) {
            rightTotal += arr[i];
            if (rightTotal < 0) break;
            rightMax = Math.max(rightMax, rightTotal);
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
