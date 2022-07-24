package test142;
// 프로그래머스/Level2/단체사진 찍기

import java.util.*;

class Solution {

    int n;
    String[] data;
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    Map<String, Integer> map = new HashMap<>();
    boolean[] visited = new boolean[8];
    int answer = 0;

    public int solution(int n, String[] data) {
        this.n = n;
        this.data = data;

        dfs(0);

        return answer;
    }

    void dfs(int depth) {
        if(depth == 8) {
            if(check()) {
                answer++;
            }
        }

        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                map.put(friends[i], depth);
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    boolean check() {
        for(int i = 0; i < n; i++) {
            String line = data[i];
            int friend1 = map.get(line.substring(0, 1));
            int friend2 = map.get(line.substring(2, 3));
            int diff1 = Math.abs(friend1 - friend2) - 1;
            String op = line.substring(3, 4);
            int diff2 = Integer.parseInt(line.substring(4, 5));

            if(op.equals("=")) {
                if(diff1 != diff2) {
                    return false;
                }
            } else if(op.equals("<")) {
                if(diff1 >= diff2) {
                    return false;
                }
            } else {
                if(diff1 <= diff2) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Test142 {

}
