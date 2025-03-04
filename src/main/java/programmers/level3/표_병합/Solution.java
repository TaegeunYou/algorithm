package main.java.programmers.level3.표_병합;

import java.util.*;

class Solution {

    int[][] board = new int[51][51]; //해당 좌표가 몇 번 그룹에 있는지, 0이면 그룹 없음
    Map<Integer, List<Node>> mapGroup = new HashMap<>();  //각 그룹안에 몇 번 좌표가 있는지
    Map<Integer, String> mapValue = new HashMap<>();  //해당 그룹의 value가 어떤건지
    int groupCount = 0;
    List<String> prints = new ArrayList<>();

    public String[] solution(String[] commands) {
        for (String command : commands) {
            String[] split = command.split(" ");
            String instruction = split[0];
            if (instruction.equals("UPDATE") && split.length == 4) {
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                String value = split[3];
                update1(r, c, value);
            } else if (instruction.equals("UPDATE")) {
                String value1 = split[1];
                String value2 = split[2];
                update2(value1, value2);
            } else if (instruction.equals("MERGE")) {
                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                int r2 = Integer.parseInt(split[3]);
                int c2 = Integer.parseInt(split[4]);
                merge(r1, c1, r2, c2);
            } else if (instruction.equals("UNMERGE")) {
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                unmerge(r, c);
            } else { //PRINT
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                print(r, c);
            }
        }
        String[] answer = new String[prints.size()];
        for (int i = 0; i < prints.size(); i++) {
            answer[i] = prints.get(i);
        }
        return answer;
    }

    private void update1(int r, int c, String value) {
        if (board[r][c] == 0) {  //그룹 없음
            int groupNum = ++groupCount;
            board[r][c] = groupNum;
            List<Node> nodes = new ArrayList<>();
            nodes.add(new Node(r, c));
            mapGroup.put(groupNum, nodes);
            mapValue.put(groupNum, value);
        } else {
            int groupNum = board[r][c];
            mapValue.put(groupNum, value);
        }
    }

    private void update2(String value1, String value2) {
        if (mapValue.isEmpty()) {
            return;
        }
        for (int groupNum : mapValue.keySet()) {
            String str = mapValue.get(groupNum);
            if (str.equals(value1)) {
                mapValue.put(groupNum, value2);
            }
        }
    }

    private void merge(int r1, int c1, int r2, int c2) {
        if (r1 == r2 && c1 == c2) {
            return;
        }
        int group1 = board[r1][c1];
        int group2 = board[r2][c2];
        if (group1 != 0 && group1 == group2) {
            return;
        }
        List<Node> nodes1 = mapGroup.getOrDefault(group1, new ArrayList<>());
        if (nodes1.isEmpty()) {
            nodes1.add(new Node(r1, c1));
        }
        List<Node> nodes2 = mapGroup.getOrDefault(group2, new ArrayList<>());
        if (nodes2.isEmpty()) {
            nodes2.add(new Node(r2, c2));
        }
        if (mapValue.get(group1) != null) {
            //group1이 있음
            nodes1.addAll(nodes2);
            for (Node node : nodes2) {
                board[node.x][node.y] = group1;
            }
            mapGroup.remove(group2);
            mapValue.remove(group2);
        } else if (mapValue.get(group2) != null) {
            //group2만 있음
            nodes2.addAll(nodes1);
            for (Node node : nodes1) {
                board[node.x][node.y] = group2;
            }
        } else {
            //값은 없었지만 그룹은 있을 수 있음.
            int groupNum = ++groupCount;
            List<Node> nodes = new ArrayList<>();
            nodes.addAll(nodes1);
            nodes.addAll(nodes2);
            mapGroup.put(groupNum, nodes);
            mapGroup.remove(group1);
            mapGroup.remove(group2);
            for (Node node : nodes) {
                board[node.x][node.y] = groupNum;
            }
        }
    }

    private void unmerge(int r, int c) {
        //r, c 그룹에서 해당 좌표 제외하고 그룹에서 제외하기
        int group = board[r][c];
        if (group == 0) {
            return;
        }
        for (Node node : mapGroup.get(group)) {
            if (node.x == r && node.y == c) {
                continue;
            }
            board[node.x][node.y] = 0;
        }
        List<Node> nodes = mapGroup.get(group);
        nodes.clear();
        nodes.add(new Node(r, c));
    }

    private void print(int r, int c) {
        int group = board[r][c];
        String str = mapValue.get(group);
        if (str == null) {
            prints.add("EMPTY");
        } else {
            prints.add(str);
        }
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
