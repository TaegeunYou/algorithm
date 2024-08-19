package main.java.programmers.level2.조이스틱;

class Solution {
    public int solution(String name) {
        int upDownCount = 0;
        int notA = 0;
        for (int i = 0; i < name.length(); i++) {
            char tmp = name.charAt(i);
            if (tmp != 'A') {
                upDownCount += Math.min(tmp - 'A', 'Z' + 1 - tmp);
                notA++;
            }
        }
        int q = 0;
        if (name.charAt(0) != 'A') q = 1;
        int minRightLeftCount = Integer.MAX_VALUE;
        for (int i = 0; i <= notA; i++) {
            minRightLeftCount = Math.min(
                minRightLeftCount,
                findIdxDiff(true, i, name) * 2 + findIdxDiff(false, notA - i - q, name)
            );
            minRightLeftCount = Math.min(
                minRightLeftCount,
                findIdxDiff(false, i, name) * 2 + findIdxDiff(true, notA - i - q, name)
            );
        }
        return upDownCount + minRightLeftCount;
    }

    private int findIdxDiff(boolean isLeft, int seq, String name) {
        int tmpIdx = 0;
        int remainI = seq;
        int result = 0;
        int plus = isLeft ? 1 : -1;
        while (remainI > 0) {
            result++;
            tmpIdx = (name.length() + (tmpIdx - plus)) % name.length();
            if (name.charAt(tmpIdx) != 'A') remainI--;
        }
        return result;
    }

}