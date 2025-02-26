package main.java.programmers.level3.외벽_점검;

import java.util.*;

class Solution {

    int n;
    List<Integer> weaks;
    List<Integer> dists;
    int distLength;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        weaks = new ArrayList<>();
        dists = new ArrayList<>();
        distLength = dist.length;
        for (int i : weak) {
            weaks.add(i);
        }
        for (int i : dist) {
            dists.add(i);
        }
        dists.sort(Comparator.reverseOrder());
        for (int i = 0; i < weaks.size(); i++) {
            dfs(i);
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
    }

    private void dfs(int weakIdx) {
        if (weaks.isEmpty()) {
            int tmpAnswer = distLength - dists.size();
            answer = Math.min(answer, tmpAnswer);
            return;
        }
        if (dists.isEmpty() || weakIdx == -1) {
            return;
        }
        int tmpWeak = weaks.get(weakIdx);
        int nextWeak = weaks.get((weakIdx + 1) % weaks.size());
        for (int i = 0; i < dists.size(); i++) {
            int tmpDist = dists.get(i);
            int position = tmpWeak + tmpDist;
            List<Integer> removeNums = new ArrayList<>();
            removeNums.add(tmpWeak);
            int tmpPosition = position % n;
            if (position / n > 0) {
                for (int j = weakIdx + 1; j < weaks.size(); j++) {
                    removeNums.add(weaks.get(j));
                    nextWeak = weaks.get((j + 1) % weaks.size());
                }
                for (int j = 0; j < weaks.size(); j++) {
                    if (weaks.get(j) > tmpPosition) {
                        break;
                    }
                    removeNums.add(weaks.get(j));
                    nextWeak = weaks.get((j + 1) % weaks.size());
                }
            } else {
                for (int j = weakIdx + 1; j < weaks.size(); j++) {
                    if (weaks.get(j) > tmpPosition) {
                        break;
                    }
                    removeNums.add(weaks.get(j));
                    nextWeak = weaks.get((j + 1) % weaks.size());
                }
            }
            for (Integer j : removeNums) {
                weaks.remove(j);
            }
            int nextWeakIdx = -1;
            for (int j = 0; j < weaks.size(); j++) {
                if (weaks.get(j) == nextWeak) {
                    nextWeakIdx = j;
                    break;
                }
            }
            dists.remove(i);
            dfs(nextWeakIdx);
            dists.add(i, tmpDist);
            weaks.addAll(removeNums);
            weaks.sort(Comparator.naturalOrder());
        }
    }
}
