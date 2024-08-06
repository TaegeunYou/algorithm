package main.java.programmers.level2.전력망을_둘로_나누기;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    final HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    int answer = Integer.MAX_VALUE;
    int count = 0;
    public int solution(int n, int[][] wires) {
        int[] ch = new int[n + 1];
        for (int[] arr : wires) {
            ArrayList<Integer> tmp1 = map.getOrDefault(arr[0], new ArrayList<>());
            ArrayList<Integer> tmp2 = map.getOrDefault(arr[1], new ArrayList<>());
            tmp1.add(arr[1]);
            tmp2.add(arr[0]);
            map.put(arr[0], tmp1);
            map.put(arr[1], tmp2);
        }
        for (int[] arr : wires) {
            int a = arr[0];
            int b = arr[1];

            ch[a] = 1;
            count = 0;
            dfs(a, ch, b);
            int tmpCount = count;
            ch[a] = 0;

            ch[b] = 1;
            count = 0;
            dfs(b, ch, a);
            ch[b] = 0;

            answer = Math.min(answer, Math.abs(tmpCount - count));
        }
        return answer;
    }

    private void dfs(int num, int[] ch, int exclude) {
        count++;
        for (int i : map.get(num)) {
            if (ch[i] == 0 && i != exclude) {
                ch[i] = 1;
                dfs(i, ch, exclude);
                ch[i] = 0;
            }
        }
    }

}