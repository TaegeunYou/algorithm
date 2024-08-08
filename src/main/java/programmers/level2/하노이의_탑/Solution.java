package main.java.programmers.level2.하노이의_탑;

import java.util.ArrayList;

class Solution {

    ArrayList<Move> list = new ArrayList<>();
    public int[][] solution(int n) {
        dfs(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < answer.length; i++) {
            Move tmp = list.get(i);
            answer[i][0] = tmp.from;
            answer[i][1] = tmp.to;
        }
        return answer;
    }

    private void dfs(int n, int start, int mid, int end) {
        if (n == 1) {
            list.add(new Move(start, end));
            return;
        }

        //n-1개를 start -> mid
        dfs(n - 1, start, end, mid);

        //1개를 start -> end
        list.add(new Move(start, end));

        //n-1개를 mid -> end
        dfs(n - 1, mid, start, end);
    }

    class Move {
        int from;
        int to;

        public Move(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

}