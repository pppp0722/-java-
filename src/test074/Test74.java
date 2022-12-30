package test074;
// 백트래킹/프로그래머스/Level3/단어 변환

import java.util.HashMap;
import java.util.Map;

public class Test74 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = solution.solution(begin, target, words);
        System.out.println(result);
    }
}

class Solution {

    private int n;
    private int len;
    private String targetWord;
    private int minDepth;
    private Map<String, Boolean> visited;

    public int solution(String begin, String target, String[] words) {
        n = words.length;
        len = begin.length();
        targetWord = target;
        minDepth = n;
        visited = new HashMap<>();
        for (String word : words) {
            if (word.equals(begin)) {
                continue;
            }
            visited.put(word, false);
        }

        backtrack(0, begin); // 재귀 시작

        return minDepth == n ? 0 : minDepth;
    }

    private void backtrack(int depth, String word) {
        if (depth == minDepth) {
            return;
        }

        if (word.equals(targetWord)) {
            minDepth = depth;
            return;
        }

        for (String nextWord : visited.keySet()) {
            if (visited.get(nextWord) || !check(word, nextWord)) {
                continue;
            }

            visited.replace(word, true);
            backtrack(depth + 1, nextWord);
            visited.replace(word, false);
        }
    }

    private boolean check(String word, String nextWord) {
        int ct = 0;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) == nextWord.charAt(i)) {
                ct++;
            }
        }
        return ct == len - 1;
    }
}