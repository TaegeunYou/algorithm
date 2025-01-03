package main.java.baekjoon.silver._17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char left = str.charAt(0);
        char right = str.charAt(str.length() - 1);
        char[] arr = str.toCharArray();
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (left == arr[i]) {
                leftSum++;
                continue;
            }
            break;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (right == arr[i]) {
                rightSum++;
                continue;
            }
            break;
        }
        int totalR = 0;
        for (char c : arr) {
            if (c == 'R') {
                totalR++;
            }
        }
        int totalB = n - totalR;
        if (totalB == 0 || totalR == 0) {
            System.out.println(0);
            return;
        }
        int answer = Integer.MAX_VALUE;
        if (left == 'R') {
            answer = Math.min(answer, totalR - leftSum);
        } else {
            answer = Math.min(answer, totalB - leftSum);
        }
        if (right == 'R') {
            answer = Math.min(answer, totalR - rightSum);
        } else {
            answer = Math.min(answer, totalB - rightSum);
        }
        answer = Math.min(answer, totalB);
        answer = Math.min(answer, totalR);
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
