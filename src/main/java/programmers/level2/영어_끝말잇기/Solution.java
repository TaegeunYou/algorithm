package main.java.programmers.level2.영어_끝말잇기;

import java.util.ArrayList;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i];
            boolean isThirdRuleTrue = i == 0 || words[i-1].charAt(words[i-1].length() - 1) == tmp.charAt(0);
            boolean isForthRuleTrue = !list.contains(tmp);
            boolean isFifthRuleTrue = tmp.length() != 1;
            if (isThirdRuleTrue && isForthRuleTrue && isFifthRuleTrue) {
                list.add(words[i]);
            } else {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }
}