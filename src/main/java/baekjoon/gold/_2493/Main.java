package main.java.baekjoon.gold._2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = execute(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private List<Integer> execute(int[] arr) {
        Deque<Top> stack = new ArrayDeque<>();
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            while (!stack.isEmpty() && stack.peekLast().height < height) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                answers.add(0);
            } else {
                answers.add(stack.peekLast().num);
            }
            stack.addLast(new Top(i + 1, height));
        }
        return answers;
    }

    private class Top {
        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
