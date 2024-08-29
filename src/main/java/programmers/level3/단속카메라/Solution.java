package main.java.programmers.level3.단속카메라;

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        if (routes.length == 0) return 0;
        Arrays.sort(routes, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int camera = routes[0][1];
        int count = 1;
        for (int i = 1; i < routes.length; i++) {
            if (camera < routes[i][0] || camera > routes[i][1]) {
                camera = routes[i][1];
                count++;
            }
        }
        return count;
    }
}