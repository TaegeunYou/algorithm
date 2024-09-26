package main.java.algolab.HanoiTowerTop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class main {

    HashMap<Integer, ArrayDeque<Integer>> map;
    StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            map = new HashMap<>();
            for (int j = 1; j <= 3; j++) {
                map.put(j, new ArrayDeque<>());
                if (j == 1) {
                    for (int k = n; k >= 1; k--) {
                        ArrayDeque<Integer> stack = map.get(j);
                        stack.offerLast(k);
                    }
                }
            }
            execute(n, 1, 2, 3);
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private void execute(int n, int from, int mid, int to) {
        if (n == 1) {
            move(from, to);
            return;
        }
        execute(n - 1, from, to, mid);
        execute(1, from, mid, to);
        execute(n - 1, mid, from, to);
    }

    private void move(int from, int to) {
        ArrayDeque<Integer> fromStack = map.get(from);
        ArrayDeque<Integer> toStack = map.get(to);
        int moveBlock = fromStack.pollLast();
        toStack.offerLast(moveBlock);
        if (from == 3) {
            printTargetStackLast(fromStack);
            return;
        }
        if (to == 3) {
            printTargetStackLast(toStack);
        }
    }

    private void printTargetStackLast(ArrayDeque<Integer> stack) {
        if (stack.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(stack.peekLast());
        }
        sb.append(" ");
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }

}