package test086;
// 프로그래머스/Level2/메뉴 리뉴얼

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test86 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] answer = solution.solution(orders, course);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}

class Solution {

    Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            order = sortString(order);
            dfs(new boolean[order.length()], order, 0, course);
        }
        List<String> keySetList = new ArrayList<>(map.keySet());
        List<String> answer = new ArrayList<>();
        for (String key : keySetList) {
            if(map.get(key) < 2) {
                continue;
            }
            for (int courseLength : course) {
                if (key.length() != courseLength) {
                    continue;
                }
                boolean isLargest = true;
                for (int j = 0; j < answer.size(); j++) {
                    if (answer.get(j).length() != courseLength) {
                        continue;
                    }
                    if (map.get(key) > map.get(answer.get(j))) {
                        answer.remove(j--);
                    } else if (map.get(key) < map.get(answer.get(j))) {
                        isLargest = false;
                        break;
                    }
                }
                if (isLargest) {
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    public void dfs(boolean[] visited, String order, int depth, int[] course) {
        if (depth == order.length()) {
            String menu = "";
            for (int i = 0; i < order.length(); i++) {
                if (visited[i]) {
                    menu += order.charAt(i);
                }
            }
            if (menu.length() < 2) {
                return;
            }
            for (int courseLength : course) {
                if (menu.length() == courseLength) {
                    if (!map.containsKey(menu)) {
                        map.put(menu, 1);
                    } else {
                        map.replace(menu, map.get(menu) + 1);
                    }
                }
            }
        } else {
            visited[depth] = true;
            dfs(visited, order, depth + 1, course);
            visited[depth] = false;
            dfs(visited, order, depth + 1, course);
        }
    }

    public String sortString(String string) {
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}