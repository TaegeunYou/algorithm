package main.java.baekjoon.gold._2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }
        List<Integer> result = execute(arr);
        result.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (int i : result) {
            sb.append(i).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private List<Integer> execute(int[] arr) {
        List<Integer> answers = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            List<Integer> top = new ArrayList<>();
            List<Integer> bottom = new ArrayList<>();
            int tmp = i;
            while (true) {
                if (top.contains(tmp)) {
                    break;
                }
                if (bottom.contains(arr[tmp])) {
                    break;
                }
                top.add(tmp);
                bottom.add(arr[tmp]);
                tmp = arr[tmp];
            }
            if (isSame(top, bottom)) {
                for (int j : top) {
                    visited[j] = true;
                    answers.add(j);
                }
            }
        }
        return answers;
    }

    private boolean isSame(List<Integer> top, List<Integer> bottom) {
        if (top.size() != bottom.size()) {
            return false;
        }
        for (int i : top) {
            if (!bottom.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
