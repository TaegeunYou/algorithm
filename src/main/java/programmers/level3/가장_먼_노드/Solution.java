package main.java.programmers.level3.가장_먼_노드;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(int n, int[][] edge) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            ArrayList<Integer> aList = map.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> bList = map.getOrDefault(b, new ArrayList<>());
            aList.add(b);
            bList.add(a);
            map.put(a, aList);
            map.put(b, bList);
        }
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        int answer = 0;
        while (!queue.isEmpty()) {
            int tmpCount = 0;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int tmp = queue.pollFirst();
                if (!visited[tmp]) {
                    visited[tmp] = true;
                    tmpCount++;
                    for (int next : map.get(tmp)) {
                        if (!visited[next]) {
                            queue.offerLast(next);
                        }
                    }
                }
            }
            if (tmpCount != 0) answer = tmpCount;
        }
        return answer;
    }

}