package main.java.programmers.level2.수식_최대화;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    int[] ch = new int[3];
    char[] opTmp = new char[3];
    ArrayList<Character> op = new ArrayList<>(Arrays.asList('+', '-', '*'));

    public long solution(String expression) {
        ArrayList<String> exs = new ArrayList<>();
        String str = "";
        for (char c : expression.toCharArray()) {
            if (op.contains(c)) {
                exs.add(str);
                exs.add(Character.toString(c));
                str = "";
            } else {
                str += c;
            }
        }
        exs.add(str);
        ArrayList<char[]> list = new ArrayList<>();
        makeOperatorSeq(0, list);
        long answer = 0;
        for (char[] arr : list) {
            ArrayList<String> tmp = new ArrayList<>(exs);
            while (tmp.size() != 1) {
                execute(tmp, arr);
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(tmp.get(0))));
        }
        return answer;
    }

    private void makeOperatorSeq(int idx, ArrayList<char[]> list) {
        if (idx == op.size()) {
            list.add(Arrays.copyOf(opTmp, op.size()));
            return;
        }
        for (int i = 0; i < op.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                opTmp[idx] = op.get(i);
                makeOperatorSeq(idx + 1, list);
                ch[i] = 0;
            }
        }
    }

    private void execute(ArrayList<String> tmp, char[] arr) {
        for (char ex : arr) {
            if (tmp.contains(Character.toString(ex))) {
                int op = tmp.indexOf(Character.toString(ex));
                String a = tmp.get(op - 1);
                String b = tmp.get(op + 1);
                long result;
                if (ex == '+') {
                    result = Long.parseLong(a) + Long.parseLong(b);
                } else if (ex == '-') {
                    result = Long.parseLong(a) - Long.parseLong(b);
                } else {
                    result = Long.parseLong(a) * Long.parseLong(b);
                }
                tmp.remove(op + 1);
                tmp.remove(op);
                tmp.remove(op - 1);
                tmp.add(op - 1, Long.toString(result));
                break;
            }
        }
    }

}