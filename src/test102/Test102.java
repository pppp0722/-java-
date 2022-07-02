package test102;
// 프로그래머스/Level3/보석 쇼핑

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test102 {

    public static void main(String[] args) {
        String[] gems = {"A", "A", "B"};
        int[] result = new Solution().solution(gems);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class Solution {

    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }
        int distinctGemsNum = set.size();

        Map<String, Integer> bought = new HashMap<>();
        int l = 0;
        int r = 0;
        int answerL = 1;
        int answerR = gems.length;
        int minLen = gems.length - 1;
        while (l <= r) {
            if (bought.size() == distinctGemsNum) {
                int len = r - l - 1;
                if (len < minLen) {
                    minLen = len;
                    answerL = l + 1;
                    answerR = r;
                }

                bought.put(gems[l], bought.get(gems[l]) - 1);
                if (bought.get(gems[l]) == 0) {
                    bought.remove(gems[l]);
                }
                l++;
            } else {
                if (r == gems.length) {
                    break;
                }

                bought.put(gems[r], bought.getOrDefault(gems[r], 0) + 1);
                r++;
            }
        }

        return new int[]{answerL, answerR};
    }
}