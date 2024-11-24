package main.java.baekjoon.gold._2281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

//메모리 초과
public class Main {
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int result = execute(n, m, arr);
        System.out.println(result);
        br.close();
    }

    private int execute(int n, int m, int[] arr) {
        ArrayList<ArrayList<State>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        ArrayList<State> start = new ArrayList<>();
        start.add(new State(0, m - arr[1]));
        dp.add(start);

        for (int i = 2; i <= n; i++) {
            ArrayList<State> tmpList = new ArrayList<>();
            ArrayList<State> states = dp.get(i - 1);
            int tmp = arr[i];
            for (State state : states) {
                //같은 줄에 들어가기
                if (state.remain >= tmp + 1) {
                    tmpList.add(new State(state.sum, state.remain - (tmp + 1)));
                }
                //다음 줄에 들어가기
                int tmpPow = (int) Math.pow(state.remain, 2);
                tmpList.add(new State(state.sum + tmpPow, m - tmp));
            }
            dp.add(tmpList);
        }
        ArrayList<State> results = dp.get(dp.size() - 1);
        return results.stream().min(Comparator.comparingInt(o -> o.sum)).get().sum;
    }

    private class State {
        int sum;
        int remain;

        public State(int sum, int remain) {
            this.sum = sum;
            this.remain = remain;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
