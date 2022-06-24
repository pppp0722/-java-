package test099;
// 프로그래머스/Level3/순위

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test99 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[][] results = {{1, 2}, {4, 5}, {3, 4}, {2, 3}};
        int answer = solution.solution(n, results);
        System.out.println(answer);
    }
}

class Solution {

    public int solution(int n, int[][] results) {
        Map<Integer, Result> map = new HashMap<>();
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            if (!map.containsKey(winner)) {
                map.put(winner, new Result());
            }
            if (!map.containsKey(loser)) {
                map.put(loser, new Result());
            }

            Result winnerResult = map.get(winner);
            Result loserResult = map.get(loser);
            for (Integer winnersWinner : winnerResult.lose) {
                Result winnersWinnerResult = map.get(winnersWinner);
                winnersWinnerResult.win.addAll(loserResult.win);
                winnersWinnerResult.win.add(loser);
            }
            winnerResult.win.addAll(loserResult.win);
            winnerResult.win.add(loser);

            for (Integer losersLoser : loserResult.win) {
                Result losersLoserResult = map.get(losersLoser);
                losersLoserResult.lose.addAll(winnerResult.lose);
                losersLoserResult.lose.add(winner);
            }
            loserResult.lose.addAll(winnerResult.lose);
            loserResult.lose.add(winner);
        }

        int answer = 0;
        for (Integer key : map.keySet()) {
            Result result = map.get(key);
            if (result.win.size() + result.lose.size() == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}

class Result {

    public Set<Integer> win = new HashSet<>();

    public Set<Integer> lose = new HashSet<>();
}