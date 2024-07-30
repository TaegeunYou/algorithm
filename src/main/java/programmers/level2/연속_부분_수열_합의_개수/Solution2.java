package main.java.programmers.level2.연속_부분_수열_합의_개수;

import java.util.HashSet;

class Solution2 {

    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[elements.length * 2];
        for (int i = 0; i < elements.length * 2; i++) {
            arr[i] = elements[i % elements.length];
        }
        for (int i = 0; i <= elements.length; i++) {    //수열의 시작 인덱스
            int sum = 0;
            for (int j = i; j < i + elements.length; j++) {
                sum += arr[j];
                set.add(sum);
            }
        }
        return set.size();
    }
}