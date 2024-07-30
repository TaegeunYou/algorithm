package main.java.programmers.level2.연속_부분_수열_합의_개수;

import java.util.HashSet;
import java.util.Set;

class Solution {

    static Set<Integer> set = new HashSet<>();
    static int[] element;
    static int len;
    static int[] ch;

    public int solution(int[] elements) {
        element = elements;
        len = elements.length;
        ch = new int[len * 2];
        ch[0] = 1;
        dfs(0, 0, 0);
        return set.size();
    }

    static void dfs(int lt, int rt, int sum) {
        if (rt - len == lt || lt > rt) return;
        ch[rt] = 1;
        set.add(sum);
        if (ch[rt + 1] == 0 && rt < len * 2 - 1) {
            dfs(lt, rt + 1, sum + element[rt % len]);
        }
        if (lt < len - 1) {
            dfs(lt + 1, rt, sum - element[lt % len]);
        }
    }

}