package main.java.programmers.level2.단체사진_찍기;

import java.util.Arrays;

class Solution {
    int n;
    String[] data;
    char[] people;
    char[] board;
    int answer = 0;
    public int solution(int n, String[] data) {
        this.n = n;
        this.data = data;
        people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        board = new char[8];
        Arrays.fill(board, '0');
        dfs(0);
        return answer;
    }

    private void dfs(int idx) {
        if (idx == 8) {
            if (check()) answer++;
            return;
        }
        char tmp = people[idx];
        for (int i = 0; i < 8; i++) {
            if (board[i] != '0') continue;
            board[i] = tmp;
            dfs(idx + 1);
            board[i] = '0';
        }
    }

    private boolean check() {
        boolean avail = true;
        for (String tmpData : data) {
            char person1 = tmpData.charAt(0);
            char person2 = tmpData.charAt(2);
            char action = tmpData.charAt(3);
            int distance = tmpData.charAt(4) - '0';
            int person1Idx = getIdx(person1);
            int person2Idx = getIdx(person2);
            int personDistance = Math.abs(person1Idx - person2Idx) - 1;
            boolean flag;
            if (action == '>') {
                flag = (personDistance > distance);
            } else if (action == '<') {
                flag = (personDistance < distance);
            } else {
                flag = (personDistance == distance);
            }
            if (!flag) {
                avail = false;
                break;
            }
        }
        return avail;
    }

    private int getIdx(char person) {
        for (int i = 0; i < 8; i++) {
            if (board[i] == person) return i;
        }
        return -1;
    }

}