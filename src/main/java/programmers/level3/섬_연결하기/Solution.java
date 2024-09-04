package main.java.programmers.level3.섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 크루스칼 알고리즘
 */
class Solution {

    int[] unf;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        unf = new int[n];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int dist = cost[2];
            if (find(a) != find(b)) {
                union(a, b);
                answer += dist;
            }
        }

        return answer;
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    private int find(int a) {
        if (a == unf[a]) return a;
        return unf[a] = find(unf[a]);
    }

}