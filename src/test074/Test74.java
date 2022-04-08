package test074;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스/Level3/단어 변환
// DFS/BFS
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
    String targetWord;
    String[] wordArray;
    int minDepth;

    public int solution(String begin, String target, String[] words) {
        targetWord = target;
        wordArray = words;
        minDepth = words.length + 1;
        Map<String, Boolean> visted = new HashMap<>();
        visted.put(begin, false);
        for(int i = 0; i < words.length; i++) {
            visted.put(words[i], false);
        }

        dfs(begin, visted, 0); // 재귀 시작

        return minDepth != words.length + 1 ? minDepth : 0;
    }

    public void dfs(String word, Map<String, Boolean> visted, int depth) {
        visted.replace(word, true);

        if(word.equals(targetWord)) {
            if(depth < minDepth) minDepth = depth;
            return;
        }

        for(int i = 0; i < wordArray.length; i++) {
            String nextWord = wordArray[i];

            if(visted.get(nextWord)) continue;

            int matches = 0;
            for(int j = 0; j < word.length(); j++) {
                if(word.charAt(j) == nextWord.charAt(j)) matches++;
            }
            if(matches != word.length() - 1) continue;

            Map<String, Boolean> newVisted = new HashMap<>();
            for(Map.Entry<String, Boolean> entry : visted.entrySet()) {
                newVisted.put(entry.getKey(), entry.getValue());
            }

            dfs(nextWord, newVisted,depth + 1);
        }
    }
}