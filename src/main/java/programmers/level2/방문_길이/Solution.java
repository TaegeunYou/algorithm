package main.java.programmers.level2.방문_길이;

/**
 * U: 위쪽으로 한 칸 가기
 *
 * D: 아래쪽으로 한 칸 가기
 *
 * R: 오른쪽으로 한 칸 가기
 *
 * L: 왼쪽으로 한 칸 가기
 */
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 5;
        int y = 5;
        int size = 10;
        int[][][][] ch = new int[size + 1][size + 1][size + 1][size + 1];
        for (char c : dirs.toCharArray()) {
            int nx;
            int ny;
            if (c == 'U') {
                nx = x;
                ny = y + 1;
            } else if (c == 'D') {
                nx = x;
                ny = y - 1;
            } else if (c == 'R') {
                nx = x + 1;
                ny = y;
            } else {
                nx = x - 1;
                ny = y ;
            }
            if (nx >= 0 && ny >= 0 && nx <= size && ny <= size) {
                if (ch[x][y][nx][ny] == 0) {
                    ch[x][y][nx][ny] = 1;
                    ch[nx][ny][x][y] = 1;
                    answer++;
                }
                x = nx;
                y = ny;
            }
        }
        return answer;
    }
}