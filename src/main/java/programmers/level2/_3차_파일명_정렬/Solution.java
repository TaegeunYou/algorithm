package main.java.programmers.level2._3차_파일명_정렬;

import java.util.ArrayList;
import java.util.Collections;

//["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
class Solution {
    public String[] solution(String[] files) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String head = "";
            String num = "";
            for (char c : files[i].toCharArray()) {
                if (num.isEmpty() && !Character.isDigit(c)) {
                    head += c;
                } else if (Character.isDigit(c)) {
                    num += c;
                } else {
                    break;
                }
            }
            list.add(new Node(head.toLowerCase(), Integer.parseInt(num), i + 1, files[i]));
        }
        Collections.sort(list);
        String[] answer = new String[files.length];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).name;
        }
        return answer;
    }

    class Node implements Comparable<Node> {
        String head;
        int number;
        int beforeSeq;
        String name;

        public Node(String head, int number, int beforeSeq, String name) {
            this.head = head;
            this.number = number;
            this.beforeSeq = beforeSeq;
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            if (this.head.equals(o.head) && this.number == o.number) {
                return this.beforeSeq - o.beforeSeq;
            } else if (this.head.equals(o.head)) {
                return this.number - o.number;
            } else {
                return this.head.compareTo(o.head);
            }
        }
    }
}