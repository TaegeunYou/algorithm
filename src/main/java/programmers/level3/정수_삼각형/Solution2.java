package main.java.programmers.level3.정수_삼각형;

class Solution2 {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int leftParent = j - 1 >= 0 ? triangle[i - 1][j - 1] : 0;
                int rightParent = j < triangle[i - 1].length ? triangle[i - 1][j] : 0;
                triangle[i][j] += Math.max(leftParent, rightParent);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : triangle[triangle.length - 1]) {
            if (num > max) max = num;
        }
        return max;
    }

}