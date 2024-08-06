package main.java.programmers.level2.시소_짝꿍;

/**
 * [100,180,360,100,270]
 * 2, 3, 4
 */
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] arr = new int[4001];
        for (int i : weights) {
            arr[i]++;
        }
        for (int i : weights) {
            answer += (arr[i]);
            answer += (arr[i * 2]);
            if (i % 2 == 0) {
                answer += (arr[i / 2]);
                answer += (arr[i * 3 / 2]);
            }
            if (i % 3 == 0) {
                answer += (arr[i * 2 / 3]);
                answer += (arr[i * 4 / 3]);
            }
            if (i % 4 == 0) {
                answer += (arr[i * 3 / 4]);
            }
            arr[i]--;
            answer--;
        }
        return answer;
    }

}