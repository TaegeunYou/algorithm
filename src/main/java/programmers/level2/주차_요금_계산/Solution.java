package main.java.programmers.level2.주차_요금_계산;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * fees	records	result
 * [180, 5000, 10, 600]	["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
 */
class Solution {

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> minutesMap = new HashMap<>();
        for (String s : records) {
            String[] split = s.split(" ");
            String time = split[0];
            String num = split[1];
            String action = split[2];
            if (action.equals("IN")) {
                map.put(num, time);
            } else {
                String in = map.get(num);
                map.remove(num);
                minutesMap.put(num, minutesMap.getOrDefault(num, 0) + calculateMinutes(in, time));
            }
        }
        for (String num : map.keySet()) {   //나가는 기록이 없는 23:59에 나가는 차들
            minutesMap.put(num, minutesMap.getOrDefault(num, 0) + calculateMinutes(map.get(num), "23:59"));
        }
        ArrayList<String> list = new ArrayList<>(minutesMap.keySet());
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = calculatePrice(minutesMap.get(list.get(i)), fees);
        }
        return answer;
    }

    int calculateMinutes(String in, String out) {
        int inHour = Integer.parseInt(in.substring(0, 2));
        int inMinutes = Integer.parseInt(in.substring(3, 5));
        int totalInMinutes = inHour * 60 + inMinutes;
        int outHour = Integer.parseInt(out.substring(0, 2));
        int outMinutes = Integer.parseInt(out.substring(3, 5));
        int totalOutMinutes = outHour * 60 + outMinutes;
        return totalOutMinutes - totalInMinutes;
    }

    int calculatePrice(int minutes, int[] fees) {
        if (minutes <= fees[0]) {
            return fees[1];
        } else {
            return fees[1] + (int) Math.ceil((minutes * 1.0 - fees[0]) / fees[2]) * fees[3];
        }
    }
}