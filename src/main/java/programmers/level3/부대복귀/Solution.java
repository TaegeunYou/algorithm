package main.java.programmers.level3.부대복귀;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    int n;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        map = new HashMap<>();
        this.n = n;
        for (int[] arr : roads) {
            int a = arr[0];
            int b = arr[1];
            ArrayList<Integer> listA = map.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> listB = map.getOrDefault(b, new ArrayList<>());
            listA.add(b);
            listB.add(a);
            map.put(a, listA);
            map.put(b, listB);
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = execute(sources[i], destination);
        }
        return answer;
    }

    private int execute(int start, int destination) {
        if (start == destination) return 0;
        int result = 1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(start);
        boolean[] ch = new boolean[n + 1];
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean flag = true;
            for (int i = 0; i < queueSize; i++) {
                int source = queue.pollFirst();
                if (ch[source]) continue;
                ch[source] = true;
                ArrayList<Integer> list = map.get(source);
                if (list != null) {
                    for (int dest : list) {
                        if (dest == destination) return result;
                        else if (!ch[dest]) {
                            queue.offerLast(dest);
                            flag = false;
                        }
                    }
                }
            }
            result++;
            if (flag) return -1;
        }
        return result;
    }
}