package main.java.programmers.level3.보석_쇼핑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String[] gems) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> allSet = new HashSet<>();
        Set<String> tmpSet = new HashSet<>();
        int answerLt = -1;
        int answerRt = -1;
        for (String gem : gems) {
            map.putIfAbsent(gem, 0);
            allSet.add(gem);
        }
        int answerSize = allSet.size();
        if (answerSize == 1) return new int[]{1, 1};
        int minLen = Integer.MAX_VALUE;
        int lt = 0;
        int rt = 0;
        String startStr = gems[lt];
        map.put(startStr, 1);
        tmpSet.add(startStr);
        while (lt < gems.length) {
            if (tmpSet.size() == answerSize) {
                if (rt - lt + 1< minLen) {
                    answerRt = rt;
                    answerLt = lt;
                    minLen = rt - lt + 1;
                }
                String ltStr = gems[lt];
                if (map.get(ltStr) == 1) {
                    tmpSet.remove(ltStr);
                }
                map.put(ltStr, map.get(ltStr) - 1);
                lt++;
            } else {
                rt++;
                if (rt >= gems.length) break;
                String rtStr = gems[rt];
                map.put(rtStr, map.getOrDefault(rtStr, 0) + 1);
                tmpSet.add(rtStr);
            }
        }
        return new int[]{answerLt + 1, answerRt + 1};
    }

}