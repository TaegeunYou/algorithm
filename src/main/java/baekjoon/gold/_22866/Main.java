package main.java.baekjoon.gold._22866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Building> buildings = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            buildings.add(new Building(i, Integer.parseInt(st.nextToken())));
        }
        execute(buildings);
    }

    private void execute(List<Building> buildings) {
        //왼쪽
        List<Result> leftResults = new ArrayList<>();
        Deque<Building> leftStack = new ArrayDeque<>();
        for (int i = 0; i < buildings.size(); i++) {
            process(i, leftResults, leftStack, buildings, true);
        }
        //오른쪽
        List<Result> rightResults = new ArrayList<>();
        Deque<Building> rightStack = new ArrayDeque<>();
        for (int i = buildings.size() - 1; i >= 0; i--) {
            process(i, rightResults, rightStack, buildings, false);
        }
        //결과
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buildings.size(); i++) {
            final int tmpIdx = i;
            Result leftResult = leftResults.get(i);
            Result rightResult = rightResults.get(i);
            int count = leftResult.count + rightResult.count;
            Integer nearDist = Stream.of(leftResult.nearIdx, rightResult.nearIdx).filter(it -> it != -1)
                .map(it -> Math.abs(tmpIdx - it))
                .min(Comparator.naturalOrder())
                .orElse(0);
            int nearIdx = leftResult.count != 0 && Math.abs(tmpIdx - leftResult.nearIdx) == nearDist
                ? leftResult.nearIdx : rightResult.nearIdx;
            if (count == 0) {
                sb.append(0);
            } else {
                sb.append(count).append(" ").append(nearIdx + 1);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void process(int i, List<Result> results, Deque<Building> stack, List<Building> buildings, boolean isLeft) {
        Building building = buildings.get(i);
        while (!stack.isEmpty() && stack.peekLast().height <= building.height) {
            stack.pollLast();
        }
        if (stack.isEmpty()) {
            Result result = new Result(0, -1);
            if (isLeft) {
                results.add(result);
            } else {
                results.add(0, result);
            }
        } else {
            Result result = new Result(stack.size(), stack.peekLast().idx);
            if (isLeft) {
                results.add(result);
            } else {
                results.add(0, result);
            }
        }
        stack.offerLast(building);
    }

    private class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    private class Result {
        int count;
        int nearIdx;

        public Result(int count, int nearIdx) {
            this.count = count;
            this.nearIdx = nearIdx;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
