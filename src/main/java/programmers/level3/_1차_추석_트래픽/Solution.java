package main.java.programmers.level3._1차_추석_트래픽;

import java.util.*;

class Solution {
    public int solution(String[] lines) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < lines.length; i++) {
            list.add(new Node(getStartTime(lines[i]), getEndTime(lines[i])));
        }
        list.sort(Comparator.naturalOrder());
        PriorityQueue<Double> endTimePq = new PriorityQueue<>();
        int answer = 0;
        int total = 0;
        for (Node node : list) {
            while (!endTimePq.isEmpty() && endTimePq.peek() <= node.start - 1) {
                endTimePq.poll();
                total--;
            }
            endTimePq.offer(node.end);
            total++;
            answer = Math.max(answer, total);
        }
        return answer;
    }



    private double getStartTime(String line) {
        String[] split = line.split(" ");
        String timeStr = split[1];
        String[] timeSplit = timeStr.split(":");
        int hour = Integer.parseInt(timeSplit[0]) * 60 * 60;
        int minute = Integer.parseInt(timeSplit[1]) * 60;
        double second = Double.parseDouble(timeSplit[2]);
        double endTime = hour + minute + second;
        String processTimeStr = split[2];
        double processTime = Double.parseDouble(processTimeStr.split("s")[0]);
        return endTime - processTime + 0.001;
    }

    private double getEndTime(String line) {
        String[] split = line.split(" ");
        String timeStr = split[1];
        String[] timeSplit = timeStr.split(":");
        int hour = Integer.parseInt(timeSplit[0]) * 60 * 60;
        int minute = Integer.parseInt(timeSplit[1]) * 60;
        double second = Double.parseDouble(timeSplit[2]);
        double endTime = hour + minute + second;
        String processTimeStr = split[2];
        double processTime = Double.parseDouble(processTimeStr.split("s")[0]);
        return endTime;
    }

    private class Node implements Comparable<Node> {
        double start;
        double end;

        public Node(double start, double end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.start, o.start);
        }
    }
}
