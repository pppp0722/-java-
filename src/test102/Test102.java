package test102;
// 그리디/프로그래머스/Level3/보석 쇼핑

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test102 {

    public static void main(String[] args) {
        String[] gems = {"A", "B", "C", "C", "D", "A", "B", "C", "D"};
        int[] result = new Solution().solution(gems);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class Solution {

    public int[] solution(String[] gems) {
        Set<String> set1 = new HashSet<>(List.of(gems));
        Set<String> set2 = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (r < gems.length) {
            map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            set2.add(gems[r]);
            while (map.get(gems[l]) > 1) {
                map.replace(gems[l], map.get(gems[l]) - 1);
                l++;
            }
            if (r - l < len && set1.size() == set2.size()) {
                answer[0] = l + 1;
                answer[1] = r + 1;
                len = r - l;
            }
            r++;
        }
        return answer;
    }
}