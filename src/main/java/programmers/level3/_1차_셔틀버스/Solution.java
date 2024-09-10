package main.java.programmers.level3._1차_셔틀버스;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 자리를 밀어내기위해 1분 빨리 오는 경우 or 그냥 출발 시각에 맞춰서 오면 됨
 */
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        int timetableIdx = 0;
        PriorityQueue<String> queue = new PriorityQueue<>();
        String time = "09:00";
        for (int i = 0; i < n; i++) {

            //time 까지 온 애들 모두 queue에 담기
            while (timetableIdx < timetable.length && timetable[timetableIdx].compareTo(time) <= 0) {
                queue.offer(timetable[timetableIdx]);
                timetableIdx++;
            }

            //queue에서 m만큼 태워서 보내기
            int count = 0;
            String last = null;
            while (count < m && !queue.isEmpty()) {
                last = queue.poll();
                count++;
            }

            if (i == n - 1) {
                if (count == m) {
                    answer = calculate(last, -1);
                } else {
                    answer = time;
                }
                break;
            }

            //time = time + t
            time = calculate(time, t);
        }
        return answer;
    }

    private String calculate(String time, int plusTime) {
        String[] split = time.split(":");
        int totalMinutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        totalMinutes += plusTime;
        int hour = totalMinutes / 60;
        int minutes = totalMinutes % 60;
        String hourStr = hour < 10 ? "0" + hour : "" + hour;
        String minutesStr = minutes < 10 ? "0" + minutes : "" + minutes;
        return hourStr + ":" + minutesStr;
    }
}