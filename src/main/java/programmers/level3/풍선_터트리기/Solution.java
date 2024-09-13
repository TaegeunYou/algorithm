package main.java.programmers.level3.풍선_터트리기;

/**
 왼쪽에서 가장 작은거랑 오른쪽에서 가장 작은거 모두 자기 자신보다 작으면 실패
 */
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftStartArr = new int[a.length];     //자기자신을 포함해서 왼쪽에서 가장 작은거
        leftStartArr[0] = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            leftStartArr[i] = Math.min(leftStartArr[i - 1], a[i]);
        }
        int[] rightStartArr = new int[a.length];     //자기자신을 포함해서 오른쪽에서 가장 작은거
        rightStartArr[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i > 0; i--) {
            rightStartArr[i] = Math.min(rightStartArr[i + 1], a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if (i == 0 || i == a.length - 1) answer++;
            else if (leftStartArr[i] >= a[i] || rightStartArr[i] >= a[i]) answer++;
        }
        return answer;
    }
}