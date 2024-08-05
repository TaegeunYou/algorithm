package main.java.programmers.level2.소수_찾기;

import java.util.HashSet;

class Solution {

    String numbers;
    int[] ch;
    final HashSet<Integer> set = new HashSet<>();
    int max = 0;
    public int solution(String numbers) {
        this.numbers = numbers;
        ch = new int[numbers.length()];
        //만들 수 있는 숫자 리스트 만들기
        dfs("");
        //가장 큰 수 이하로 에라토스테네스의 체 만들기
        boolean[] arr = make(max);
        //소수 개수 세기
        int count = 0;
        for (int i : set) {
            if (!arr[i]) count++;
        }
        return count;
    }

    void dfs(String str) {
        if (!str.isEmpty()) {
            int tmp = Integer.parseInt(str);
            set.add(tmp);
            max = Math.max(max, tmp);
        }
        if (str.length() != numbers.length()) {
            for (int i = 0; i < numbers.length(); i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(str + numbers.charAt(i));
                    ch[i] = 0;
                }
            }
        }
    }

    //에라토스테네스의 체
    //false면 소수
    private boolean[] make(int num) {
        boolean[] arr = new boolean[num + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (!arr[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    arr[j] = true;
                }
            }
        }
        return arr;
    }

}