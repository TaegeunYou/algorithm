package main.java.programmers.level2.두_큐_합_같게_만들기;

import java.util.ArrayList;

class Solution2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long qaSum = 0;
        long qbSum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < queue1.length; i++) {
            list.add(queue1[i]);
            qaSum += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            list.add(queue2[i]);
            qbSum += queue2[i];
        }
        long target = (qaSum + qbSum) / 2;
        int lt = 0;
        int rt = queue1.length - 1;
        long sum = qaSum;
        System.out.println(list);
        while (lt != rt) {
            if (sum == target) {
                System.out.println("lt " + lt + " rt " + rt);
                break;
            }
            if (sum < target) {
                rt++;
                sum += list.get(rt % list.size());
            } else {
                if (lt < list.size()) {
                    sum -= list.get(lt);
                    lt++;
                } else break;
            }
            answer++;
        }
        return sum == target ? answer : -1;
    }

    public static void main(String[] args) {
        int solution = new Solution2().solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        System.out.println("solution = " + solution);
    }
}