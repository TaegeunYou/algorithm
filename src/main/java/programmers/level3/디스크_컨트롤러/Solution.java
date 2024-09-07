package main.java.programmers.level3.디스크_컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int tmpTime = 0;
        PriorityQueue<Job> queue = new PriorityQueue<>();
        int jobIdx = 0;
        while (jobIdx < jobs.length || !queue.isEmpty()) {

            //tmpTime 보다 작은 request 인거 넣기
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= tmpTime) {
                queue.offer(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }

            //tmpTime보다 작은 게 없으면 다음으로 들어오는 거 넣기
            if (jobIdx < jobs.length && queue.isEmpty()) {
                tmpTime = jobs[jobIdx][0];
                queue.offer(new Job(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }

            //들어온 것중에 가장 작은 거 실행
            Job job = queue.poll();
            int jobEndTime = tmpTime + job.time;
            answer += (jobEndTime - job.request);

            tmpTime = jobEndTime;
        }
        return answer / jobs.length;
    }

    class Job implements Comparable<Job>{
        int request;
        int time;

        public Job(int request, int time) {
            this.request = request;
            this.time = time;
        }

        @Override
        public int compareTo(Job job) {
            return this.time - job.time;
        }
    }
}