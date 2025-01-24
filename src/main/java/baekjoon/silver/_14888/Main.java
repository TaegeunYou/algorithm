package main.java.baekjoon.silver._14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int plus;
    int minus;
    int multiply;
    int divide;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int[] nums;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st2.nextToken());
        minus = Integer.parseInt(st2.nextToken());
        multiply = Integer.parseInt(st2.nextToken());
        divide = Integer.parseInt(st2.nextToken());
        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private void dfs(int idx, int result) {
        if (idx == nums.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        int num = nums[idx];
        if (plus > 0) {
            int tmp = result + num;
            plus--;
            dfs(idx + 1, tmp);
            plus++;
        }
        if (minus > 0) {
            int tmp = result - num;
            minus--;
            dfs(idx + 1, tmp);
            minus++;
        }
        if (multiply > 0) {
            int tmp = result * num;
            multiply--;
            dfs(idx + 1, tmp);
            multiply++;
        }
        if (divide > 0) {
            int tmp;
            if (result < 0) {
                tmp = (result * -1) / num * -1;
            } else {
                tmp = result / num;
            }
            divide--;
            dfs(idx + 1, tmp);
            divide++;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
