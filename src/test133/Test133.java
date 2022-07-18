package test133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    int N;
    String[] answer;
    Map<String, List<String>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {
        N = tickets.length;
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];

            if (!map.containsKey(from)) {
                List<String> list = new ArrayList<>();
                list.add(to);
                map.put(from, list);
            } else {
                map.get(from).add(to);
            }
        }

        String[] path = new String[N + 1];
        path[0] = "ICN";
        dfs(0, "ICN", path);

        return answer;
    }

    void dfs(int depth, String from, String[] path) {
        if (depth == N) {
            if (answer == null) {
                answer = new String[N + 1];
                for (int i = 0; i < N + 1; i++) {
                    answer[i] = path[i];
                }
            } else {
                for (int i = 0; i < N + 1; i++) {
                    if (path[i].compareTo(answer[i]) < 0) {
                        break;
                    } else if (path[i].compareTo(answer[i]) > 0) {
                        return;
                    }
                }
                for (int i = 0; i < N + 1; i++) {
                    answer[i] = path[i];
                }
            }

            return;
        }

        if (!map.containsKey(from)) {
            return;
        }

        List<String> list = map.get(from);
        for (int i = 0; i < list.size(); i++) {
            String to = list.get(0);
            path[depth + 1] = to;
            list.remove(to);
            dfs(depth + 1, to, path);
            list.add(to);
        }
    }
}

public class Test133 {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
            {"ATL", "SFO"}};
        String[] answer = new Solution().solution(tickets);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}