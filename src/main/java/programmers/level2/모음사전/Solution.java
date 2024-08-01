package main.java.programmers.level2.모음사전;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String word) {
        int sum = 0;
        ArrayList<Character> list = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        int[] arr = {781, 156, 31, 6, 1};
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            sum += (list.indexOf(c) * arr[i]);
        }
        sum += word.length();
        return sum;
    }
}
/**
 * EEEE ABCDE
 * EEEE
 */
/**
 * A AA AAA AAAA AAAAA AAAAE AAAAI AAAAO AAAAU AAAE AAAEA AAAEE
 *
 * A로 시작하는 거 개수
 * 한자리 - 1
 * 두자리 - 5
 * 세자리 - 25
 * 네자리 - 125
 * 다섯자리 - 625
 *
 * 781
 * 156
 * 31
 * 6
 *
 * EIO
 * 1 - A => 781개
 * 2 - A E => 156개 * 2 = 312
 * 3 - A E I => 31개 * 3 = 93
 * 1186
 * A~       1 + 5 + 25 + 125 + 625 = 781
 * E        1
 * EA~      1 + 5 + 25 + 125 = 156
 * EE~      1 + 5 + 25 + 125 = 156
 * EI       1
 * EIA~     1 + 5 + 25 = 31
 * EIE~     1 + 5 + 25 = 31
 * EII~     1 + 5 + 25 = 31
 * 1186 + 2 = 1188
 */