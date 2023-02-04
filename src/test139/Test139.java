package test139;
// 구현,DFS/프로그래머스/Level3/외벽 점검

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    private int lenOfOuterWall;
    private int[] weekPoints;
    private int numOfWeekPoints;
    private Integer[] distances;
    private int maxNumOfFriends;

    public int solution(int n, int[] weak, int[] dist) {
        lenOfOuterWall = n;
        weekPoints = weak;
        numOfWeekPoints = weekPoints.length;
        distances = Arrays.stream(dist).boxed().toArray(Integer[]::new);
        Arrays.sort(distances, Comparator.reverseOrder());
        maxNumOfFriends = dist.length;
        return findMinNumOfFriends();
    }

    private int findMinNumOfFriends() {
        int minNumOfFriends = -1;
        for (int i = 1; i <= maxNumOfFriends; i++) {
            boolean[] visited = new boolean[i];
            int[] order = new int[i];
            if (dfs(i, 0, visited, order)) {
                minNumOfFriends = i;
                break;
            }
        }
        return minNumOfFriends;
    }

    private boolean dfs(int numOfFriends, int depth, boolean[] visited, int[] order) {
        if (depth == numOfFriends) {
            return canCheckAll(numOfFriends, order);
        }
        for (int i = 0; i < numOfFriends; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            order[depth] = distances[i];
            if (dfs(numOfFriends, depth + 1, visited, order)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private boolean canCheckAll(int numOfFriends, int[] order) {
        boolean ret = false;
        for (int i = 0; i < numOfWeekPoints; i++) {
            int[] shiftedWeekPoints = getShiftedWeekPoints(i);
            int idx = -1;
            for (int j = 0; j < numOfFriends; j++) {
                int limit = shiftedWeekPoints[idx + 1] + order[j];
                for (int k = idx + 1; k < numOfWeekPoints; k++) {
                    if (shiftedWeekPoints[k] <= limit) {
                        idx = k;
                    } else {
                        break;
                    }
                }
            }
            if (idx == numOfWeekPoints - 1) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    private int[] getShiftedWeekPoints(int distance) {
        int[] shiftedWeekPoints = new int[numOfWeekPoints];
        for (int j = 0; j < numOfWeekPoints - distance; j++) {
            shiftedWeekPoints[j] = weekPoints[j + distance];
        }
        for (int j = numOfWeekPoints - distance; j < numOfWeekPoints; j++) {
            shiftedWeekPoints[j] = weekPoints[j + distance - numOfWeekPoints] + lenOfOuterWall;
        }
        return shiftedWeekPoints;
    }
}

public class Test139 {

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 3, 4, 9, 10};
        int[] dist = {3, 5, 7};
        int answer = new Solution().solution(n, weak, dist);
        System.out.println(answer);
    }
}
