package main.java.programmers.level3.불량_사용자;

import java.util.*;

class Solution {
    Set<String> answerSet;
    ArrayDeque<Integer> stack;
    int[] chUser;
    public int solution(String[] user_id, String[] banned_id) {
        chUser = new int[user_id.length];
        stack = new ArrayDeque<>();
        answerSet = new HashSet<>();
        dfs(0, user_id, banned_id);
        return answerSet.size();
    }

    private void dfs(int banIdx, String[] user_id, String[] banned_id) {
        if (banIdx == banned_id.length) {
            StringBuilder str = new StringBuilder();
            stack.stream().sorted().forEach(str::append);
            answerSet.add(str.toString());
            return;
        }
        for (int i = 0; i < user_id.length; i++) {
            if (chUser[i] == 0 && avail(user_id[i], banned_id[banIdx])) {
                chUser[i] = 1;
                stack.offerLast(i);
                dfs(banIdx + 1, user_id, banned_id);
                stack.pollLast();
                chUser[i] = 0;
            }
        }
    }

    private boolean avail(String userStr, String banStr) {
        if (userStr.length() != banStr.length()) return false;
        boolean flag = true;
        for (int i = 0; i < banStr.length(); i++) {
            if (banStr.charAt(i) != '*' && userStr.charAt(i) != banStr.charAt(i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}