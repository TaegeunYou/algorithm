package main.java.baekjoon.gold._17143;

import java.io.*;
import java.util.*;

public class Main {

    int r;
    int c;

    int[] upDownSeq = new int[1200];
    int[] leftRightSeq = new int[1200];

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); //상어 수
        int[][] board = new int[r][c];
        Map<Integer, Shark> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 이동 방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            map.put(i, new Shark(i, x, y, s, d, z));
            board[x][y] = i;
        }
        initialSeq();
        int answer = 0;
        for (int position = 0; position < c; position++) { //낚시왕이 오른쪽으로 한 칸 이동
            //상어 하나 잡기
            for (int xPosition = 0; xPosition < r; xPosition++) {
                if (board[xPosition][position] != 0) {
                    int id = board[xPosition][position];
                    Shark shark = map.get(id);
                    answer += shark.z;
                    board[xPosition][position] = 0;
                    map.remove(id);
                    break;
                }
            }
            //상어 이동 (board, map 업데이트)
            //updateMap 확인하고 이미 차지하고 있으면 누가 자리 차지할지 확인하기
            Map<String, Shark> updateMap = new HashMap<>();
            for (int id : map.keySet()) {
                Shark shark = map.get(id);
                Shark updateShark = move(shark);
                String key = updateShark.x + " " + updateShark.y;
                if (updateMap.get(key) == null) {
                    updateMap.put(key, updateShark);
                } else {
                    Shark fillShark = updateMap.get(key);
                    if (fillShark.z < updateShark.z) {  //새로 채우려는게 크기가 크다.
                        updateMap.put(key, updateShark);
                    }
                }
            }
            for (int id : map.keySet()) {
                Shark shark = map.get(id);
                board[shark.x][shark.y] = 0;
            }
            map.clear();
            for (String key : updateMap.keySet()) {
                Shark updateShark = updateMap.get(key);
                board[updateShark.x][updateShark.y] = updateShark.id;
                map.put(updateShark.id, updateShark);
            }
        }
        System.out.println(answer);
    }

    private Shark move(Shark shark) {
        int before;
        int result;
        int d;
        if (shark.d <= 2) {  //위아래
            int a = (r-1) * 2;
            int move = shark.s % a;
            if (shark.d == 2) {  //증가
                before = upDownSeq[shark.x + move] - 1;
                result = upDownSeq[shark.x + 1 + move] - 1;
            } else { //감소
                before = upDownSeq[2 * r - (shark.x + 2) + move] - 1;
                result = upDownSeq[2 * r - (shark.x + 1) + move] - 1;
            }
            if (result > before) {
                d = 2;
            } else {
                d = 1;
            }
            return new Shark(shark.id, result, shark.y, shark.s, d, shark.z);
        } else { //왼쪽오른쪽
            int a = (c-1) * 2;
            int move = shark.s % a;
            if (shark.d == 3) {  //증가
                before = leftRightSeq[shark.y + move] - 1;
                result = leftRightSeq[shark.y + 1 + move] - 1;
            } else {  //감소
                before = leftRightSeq[2 * c - (shark.y + 2) + move] - 1;
                result = leftRightSeq[2 * c - (shark.y + 1) + move] - 1;
            }
            if (result > before) {
                d = 3;
            } else {
                d = 4;
            }
            return new Shark(shark.id, shark.x, result, shark.s, d, shark.z);
        }
    }

    private void initialSeq() {
        boolean increase = true;
        upDownSeq[1] = 1;
        int num = 1;
        for (int i = 2; i < upDownSeq.length; i++) {
            if (increase) {
                num++;
            } else {
                num--;
            }
            upDownSeq[i] = num;
            if (num == 1) {
                increase = true;
            } else if (num == r) {
                increase = false;
            }
        }
        increase = true;
        leftRightSeq[1] = 1;
        num = 1;
        for (int i = 2; i < leftRightSeq.length; i++) {
            if (increase) {
                num++;
            } else {
                num--;
            }
            leftRightSeq[i] = num;
            if (num == 1) {
                increase = true;
            } else if (num == c) {
                increase = false;
            }
        }
    }

    private class Shark {
        int id;
        int x;
        int y;
        int s;
        int d;
        int z;
        public Shark(int id, int x, int y, int s, int d, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
