package main.java.programmers.level3.광고_삽입;

import java.util.*;

class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        int endTime = getSecond(play_time);
        int advTime = getSecond(adv_time);
        List<Event> events = new ArrayList<>() ;
        for (String log : logs) {
            String[] split = log.split("-");
            int start = getSecond(split[0]);
            int end = getSecond(split[1]);
            events.add(new Event(start, true));
            events.add(new Event(end, false));
        }
        events.sort(Comparator.naturalOrder());
        int[] record = new int[endTime];
        int eventIdx = 0;
        int tmp = 0;
        for (int i = 0; i < endTime; i++) {
            while (eventIdx < events.size() && events.get(eventIdx).time == i) {
                if (events.get(eventIdx).isStart) {
                    tmp++;
                } else {
                    tmp--;
                }
                eventIdx++;
            }
            record[i] = tmp;
        }
        long[] total = new long[endTime];
        for (int i = 0; i < advTime; i++) {
            total[0] += record[i];
        }
        long max = total[0];
        int maxTime = 0;
        for (int i = 1; i < endTime - advTime + 1; i++) {
            total[i] = total[i - 1] - record[i - 1] + record[i + advTime - 1];
            if (max < total[i]) {
                max = total[i];
                maxTime = i;
            }
        }
        return getTime(maxTime);
    }

    private int getSecond(String str) {
        String[] split = str.split(":");
        int hour = Integer.parseInt(split[0]) * 3600;
        int minute = Integer.parseInt(split[1]) * 60;
        int second = Integer.parseInt(split[2]);
        return hour + minute + second;
    }

    private String getTime(int time) {
        int hour = time / 3600;
        int hourMod = time % 3600;
        int minute = hourMod / 60;
        int second = hourMod % 60;
        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append(0);
        }
        sb.append(hour);
        sb.append(":");
        if (minute < 10) {
            sb.append(0);
        }
        sb.append(minute);
        sb.append(":");
        if (second < 10) {
            sb.append(0);
        }
        sb.append(second);
        return sb.toString();
    }

    private class Event implements Comparable<Event> {
        int time;
        boolean isStart;

        public Event(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Event o) {
            return this.time - o.time;
        }
    }
}
