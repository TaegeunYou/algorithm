package main.java.algolab.선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            int[] result = execute(arr);
            for (int j = 0; j < result.length; j++) {
                sb.append(result[j]).append(" ");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int[] execute(int[] arr) {
        int countCmpOps = 0; // 비교 연산자 실행 횟수
        int countSwaps = 0; // swap 함수 실행 횟수
        for (int i = 0; i < arr.length; i++) {
            int minValue = arr[i];
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                countCmpOps++;
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                countSwaps++;
                arr[minIdx] = arr[i];
                arr[i] = minValue;
            }
        }
        return new int[]{countCmpOps, countSwaps};
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}