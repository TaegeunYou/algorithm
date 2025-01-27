package main.java.baekjoon.gold._15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    List<Node> homes;
    List<Node> chickens;
    List<Node> choices;
    int m;
    int answer = Integer.MAX_VALUE;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st2.nextToken());
                if (tmp == 1) {
                    homes.add(new Node(i, j));
                } else if (tmp == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }
        choices = new ArrayList<>();
        dfs(0);
        System.out.println(answer);
    }

    private void dfs(int idx) {
        if (choices.size() == m) {
            int result = calculate();
            answer = Math.min(answer, result);
            return;
        }
        if (idx == chickens.size()) {
            return;
        }
        dfs(idx + 1);
        choices.add(chickens.get(idx));
        dfs(idx + 1);
        choices.remove(choices.size() - 1);
    }

    private int calculate() {
        int result = 0;
        for (Node home : homes) {
            int min = Integer.MAX_VALUE;
            for (Node choice : choices) {
                int tmp = Math.abs(home.x - choice.x) + Math.abs(home.y - choice.y);
                min = Math.min(min, tmp);
            }
            result += min;
        }
        return result;
    }

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}