package test127;
// 프로그래머스/Level2/튜플

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] solution(String s) {
        Map<Integer, int[]> map = new HashMap<>();
        int idx = 0;
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}') {
                String[] split = string.split(",");
                map.put(
                    split.length - 1,
                    Arrays.stream(split)
                        .mapToInt(Integer::parseInt)
                        .toArray()
                );
                string = "";
                idx++;
                i++;
            } else {
                if (c != '{') {
                    string += c;
                }
            }
        }

        int[] answer = new int[idx];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < idx; i++) {
            for (int num : map.get(i)) {
                if (!set.contains(num)) {
                    answer[i] = num;
                    set.add(num);
                }
            }
        }

        return answer;
    }
}

public class Test127 {

    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] result = new Solution().solution(s);
        for (int i : result) {
            System.out.println(i);
        }
    }
}