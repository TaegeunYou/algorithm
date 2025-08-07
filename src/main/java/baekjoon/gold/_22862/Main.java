package main.java.baekjoon.gold._22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = execute(n, k, arr);
        System.out.println(result);
    }

    private int execute(int n, int k, int[] arr) {
        int answer = 0;
        int lt = 0;
        int rt = 0;
        int countOdd = 0;
        int countEven = 0;
        if (arr[0] % 2 == 1) {
            countOdd++;
        } else {
            answer++;
            countEven++;
        }
        while (lt <= rt && rt < n) {
            while (rt < n - 1) {
                if (arr[rt + 1] % 2 == 1) {
                    if (countOdd < k) {
                        countOdd++;
                        rt++;
                        continue;
                    }
                    break;
                }
                countEven++;
                rt++;
            }
            answer = Math.max(answer, countEven);
            if (arr[lt] % 2 == 1) {
                countOdd--;
            } else {
                countEven--;
            }
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
