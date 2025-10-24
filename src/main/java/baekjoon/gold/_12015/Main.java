package main.java.baekjoon.gold._12015;

import java.io.*;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[n];
        result[0] = arr[0];
        int lastIdx = 0;  //현재 마지막 수
        int answer = 0;
        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            if (result[lastIdx] < tmp) {
                //현재 마지막 수보다 크면 오른쪽에 붙이기
                lastIdx++;
                result[lastIdx] = tmp;
                answer = Math.max(answer, lastIdx);
            } else {
                //들어있는 마지막 수보다 작거나 같으면 이진 탐색으로 위치 찾아서 값 넣기
                //이진 탐색으로 찾을때 왼쪽보다는 크면서 오른쪽보다는 작거나 같아야함
                int idx = binarySearch(tmp, lastIdx, result);
                result[idx] = tmp;
            }
        }
        System.out.println(answer + 1);
    }

    private int binarySearch(int tmp, int lastIdx, int[] result) {
        int lt = 0;
        int rt = lastIdx;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (result[mid] < tmp) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return lt;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
