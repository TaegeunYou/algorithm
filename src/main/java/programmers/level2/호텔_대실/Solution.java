package main.java.programmers.level2.호텔_대실;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
 */
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        for (String[] arr : book_time) {
            String[] tmp = arr[1].split(":");
            int i = Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]) + 10;
            int hour = i / 60;
            int minutes = i % 60;
            arr[1] = (hour < 10 ? "0" + hour : hour) + ":" + (minutes < 10 ? "0" + minutes : minutes);
        }
        Arrays.sort(book_time, Comparator.comparing(it -> it[0]));
        String[] list = new String[book_time.length];
        for (String[] arr : book_time) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null || arr[0].compareTo(list[i]) >= 0) {
                    list[i] = arr[1];
                    break;
                }
            }
        }
        for (String str : list) {
            if (str != null) answer++;
            else break;
        }
        return answer;
    }

}