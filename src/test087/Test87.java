package test087;
// 프로그래머스/Level2/순위 검색

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Test87 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
            "python frontend senior chicken 150", "cpp backend senior pizza 260",
            "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150", "- and - and - and chicken 100",
            "- and - and - and - 150"};
        int[] answer = solution.solution(info, query);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}

class Solution {

    HashMap<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (int i = 0; i < info.length; i++) {
            String[] infos = info[i].split(" ");
            dfs(infos, "", 0);
        }

        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String fixedQuery = query[i].replaceAll(" and ", "");
            String[] questions = fixedQuery.split(" ");
            if (map.containsKey(questions[0])) {
                answer[i] = binarySearch(questions[0], Integer.parseInt(questions[1]));
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    public void dfs(String[] infos, String key, int depth) {
        if (depth == 4) {
            if (!map.containsKey(key)) {
                List<Integer> value = new ArrayList<>();
                map.put(key, value);
            }
            map.get(key).add(Integer.parseInt(infos[4]));
            return;
        }
        dfs(infos, key + "-", depth + 1);
        dfs(infos, key + infos[depth], depth + 1);
    }

    public int binarySearch(String key, int score) {
        List<Integer> scores = map.get(key);
        int left = 0;
        int right = scores.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(scores.get(mid) < score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return scores.size() - left;
    }
}