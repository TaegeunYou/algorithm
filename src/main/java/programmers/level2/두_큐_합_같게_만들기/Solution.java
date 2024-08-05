package main.java.programmers.level2.두_큐_합_같게_만들기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 테케 11오류 : 최대 횟수 설정해줘야 함
 */
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long qaSum = 0;
        long qbSum = 0;
        Queue<Integer> qa = new LinkedList<>();
        Queue<Integer> qb = new LinkedList<>();
        for (int i : queue1) {
            qaSum += i;
            qa.offer(i);
        }
        for (int i : queue2) {
            qbSum += i;
            qb.offer(i);
        }
        if (qaSum == qbSum) return 0;
        if ((qaSum + qbSum) % 2 != 0) return 0;
        ArrayList<Integer> before = new ArrayList<>(qa);
        while (!before.equals(qa) || answer == 0) {
            if (qaSum == qbSum) break;
            if (qaSum > qbSum) {
                int tmp = qa.poll();
                qb.offer(tmp);
                qaSum -= tmp;
                qbSum += tmp;
            } else {
                int tmp = qb.poll();
                qa.offer(tmp);
                qbSum -= tmp;
                qaSum += tmp;
            }
            answer++;
        }
        return qaSum == qbSum ? answer : -1;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{10,5,1}, new int[]{2,2,2});
    }
}