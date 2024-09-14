package main.java.programmers.level1.가장_많이_받은_선물;

import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> giftMap = new HashMap<>();
        HashMap<String, Integer> totalGiveMap = new HashMap<>();
        HashMap<String, Integer> totalGetMap = new HashMap<>();
        HashMap<String, Integer> nextMonthMap = new HashMap<>();
        for (String str : gifts) {
            giftMap.put(str, giftMap.getOrDefault(str, 0) + 1);
            String[] split = str.split(" ");
            String giveFriend = split[0];
            String getFriend = split[1];
            totalGiveMap.put(giveFriend, totalGiveMap.getOrDefault(giveFriend, 0) + 1);
            totalGetMap.put(getFriend, totalGetMap.getOrDefault(getFriend, 0) + 1);
        }
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String a = friends[i];
                String b = friends[j];
                int aToB = giftMap.getOrDefault(a + " " + b, 0);
                int bToA = giftMap.getOrDefault(b + " " + a, 0);
                if (aToB > bToA) {      //A가 B에게 더 많이 줬다면
                    nextMonthMap.put(a, nextMonthMap.getOrDefault(a, 0) + 1);
                } else if (aToB < bToA) {       //B가 A에게 더 많이 줬다면
                    nextMonthMap.put(b, nextMonthMap.getOrDefault(b, 0) + 1);
                } else {    //선물 횟수가 없거나 같다면
                    int aNum = totalGiveMap.getOrDefault(a, 0) - totalGetMap.getOrDefault(a, 0);
                    int bNum = totalGiveMap.getOrDefault(b, 0) - totalGetMap.getOrDefault(b, 0);
                    if (aNum > bNum) {      //A가 B보다 선물 지수가 높다면
                        nextMonthMap.put(a, nextMonthMap.getOrDefault(a, 0) + 1);
                    } else if (aNum < bNum) {       //B가 A보다 선물 지수가 높다면
                        nextMonthMap.put(b, nextMonthMap.getOrDefault(b, 0) + 1);
                    }
                }
            }
        }
        int max = 0;
        for (String key : nextMonthMap.keySet()) {
            max = Math.max(max, nextMonthMap.get(key));
        }
        return max;
    }
}