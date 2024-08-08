package main.java.programmers.level2.테이블_해시_함수;

import java.util.Arrays;

//data	col	row_begin	row_end	result
//[[2,2,6],[1,5,10],[4,2,9],[3,8,3]]	2	2	3	4
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            } else {
                return o1[col - 1] - o2[col - 1];
            }
        });
//        Arrays.sort(data, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[col - 1] == o2[col - 1]) {
//                    return o2[0] - o1[0];
//                } else {
//                    return o1[col - 1] - o2[col - 1];
//                }
//            }
//        });
        int answer = getS(row_begin, data);
        for (int i = row_begin + 1; i <= row_end; i++) {
            answer = answer ^ getS(i, data);
        }
        return answer;
    }

    private int getS(int i, int[][] data) {
        int[] tuple = data[i - 1];
        int sum = 0;
        for (int a : tuple) {
            sum += (a % i);
        }
        return sum;
    }

}