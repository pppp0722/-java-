package test143;
// 프로그래머스/Level2/[1차] 뉴스 클러스터링

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        Map<String, Integer> map4 = new HashMap<>();

        // A 구하기
        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);
            if(c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122) {
                continue;
            }

            String str = String.valueOf(c1) + c2;

            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }

        // B 구하기
        for(int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if(c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122) {
                continue;
            }

            String str = String.valueOf(c1) + c2;

            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }

        // 교집합 구하기
        for(String key : map1.keySet()) {
            int value1 = map1.get(key);
            int value2 = 0;
            if(map2.containsKey(key)) {
                value2 = map2.get(key);
            }

            if(value2 > 0) {
                map3.put(key, Math.min(value1, value2));
            }
        }

        // 합집합 구하기
        for(String key : map1.keySet()) {
            int value = map1.get(key);
            map4.put(key, value);
        }

        for(String key : map2.keySet()) {
            int value = map2.get(key);
            if(map4.containsKey(key)) {
                map4.put(key, Math.max(value, map4.get(key)));
            } else {
                map4.put(key, value);
            }
        }

        int andNum = 0;
        for(String key : map3.keySet()) {
            andNum += map3.get(key);
        }
        int orNum = 0;
        for(String key : map4.keySet()) {
            orNum += map4.get(key);
        }

        return andNum == 0 && orNum == 0 ? 65536 : (int) (((double) andNum / orNum) * 65536);
    }
}

public class Test143 {

    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        int answer = new Solution().solution(str1, str2);
        System.out.println(answer);
    }
}
