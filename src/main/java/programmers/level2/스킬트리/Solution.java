package main.java.programmers.level2.스킬트리;

/**
 * skill	skill_trees	                    return
 * "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
 */
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String tree : skill_trees) {
            boolean flag = true;
            int expect = 0;
            for (char c : tree.toCharArray()) {
                int idx = skill.indexOf(c);
                if (expect < idx) { //배울 수 없는 스킬
                    flag = false;
                    break;
                } else if (expect == idx) {    //배울 수 있는 스킬
                    expect++;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}