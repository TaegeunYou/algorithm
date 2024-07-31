package main.java.programmers.level2.k진수에서_소수_개수_구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        for (String s : str.split("0")) {
            if (!s.isEmpty() && check(Long.parseLong(s))) {
                answer++;
            }
        }
        return answer;
    }

    public boolean check(long num) {
        boolean flag = true;
        if (num == 0 || num == 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

//    public String change(int n, int k) {
//        String str = "";
//        while (n != 0) {
//            str = n % k + str;
//            n /= k;
//        }
//        return str;
//    }


}