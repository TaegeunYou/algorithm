package main.java.baekjoon.gold._14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    List<List<Integer>> wheels;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            wheels.add(new ArrayList<>());
        }
        for (List<Integer> list : wheels) {
            String str = br.readLine();
            for (char c : str.toCharArray()) {
                list.add(c - '0');
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            execute(wheelNum, direction, true, true);
        }
        int result = calculate();
        System.out.println(result);
    }

    private void execute(int wheelNum, int direction, boolean checkLeft, boolean checkRight) {
        int wheelIdx = wheelNum - 1;
        List<Integer> wheel = wheels.get(wheelIdx);
        if (checkLeft && wheelIdx - 1 >= 0) {
            int right = wheel.get(6);
            int left = wheels.get(wheelIdx - 1).get(2);
            if (right != left) {
                execute(wheelNum - 1, direction * -1, true, false);
            }
        }
        if (checkRight && wheelIdx + 1 < wheels.size()) {
            int right = wheels.get(wheelIdx + 1).get(6);
            int left = wheel.get(2);
            if (right != left) {
                execute(wheelNum + 1, direction * -1, false, true);
            }
        }
        if (direction == 1) {
            int remove = wheel.remove(wheel.size() - 1);
            wheel.add(0, remove);
        } else {
            int remove = wheel.remove(0);
            wheel.add(remove);
        }
    }

    private int calculate() {
        int sum = 0;
        if (wheels.get(0).get(0) == 1) {
            sum += 1;
        }
        if (wheels.get(1).get(0) == 1) {
            sum += 2;
        }
        if (wheels.get(2).get(0) == 1) {
            sum += 4;
        }
        if (wheels.get(3).get(0) == 1) {
            sum += 8;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
