package main.java.algolab.최대연속부분순열Kadane;

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
            Result result = execute(n, arr);
            sb.append(result.total).append(" ");
            sb.append(result.start).append(" ");
            sb.append(result.end).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private Result execute(int n, int[] arr) {
        int max = 0;
        int maxStatIdx = -1;
        int maxEndIdx = -1;
        int tmpTotal = 0;
        int startIdx = 0;
        for (int j = 0; j < n; j++) {
            tmpTotal += arr[j];
            if (tmpTotal < 0 || arr[startIdx] == 0) {
                tmpTotal = 0;
                startIdx = j + 1;
            } else if (tmpTotal > max) {
                max = tmpTotal;
                maxStatIdx = startIdx;
                maxEndIdx = j;
            }
        }
        if (max == 0) return new Result(max, -1, -1);
        return new Result(max, maxStatIdx, maxEndIdx);
    }

    class Result {
        int total;
        int start;
        int end;

        public Result(int total, int start, int end) {
            this.total = total;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
