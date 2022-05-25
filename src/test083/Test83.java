package test083;

// 프로그래머스/Level3/양과 늑대
public class Test83 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] info = {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}, {3, 7}, {4, 8}, {6, 9},
            {9, 10}};
        long answer = solution.solution(info, edges);
        System.out.println(answer);
    }
}

class Solution {

    int[] gInfo;
    int[][] gEdges;
    int maxSheepCnt = 0;

    public int solution(int[] info, int[][] edges) {
        gInfo = info;
        gEdges = edges;
        boolean[] initVisited = new boolean[info.length];
        dfs(0, initVisited, 0, 0);

        return maxSheepCnt;
    }

    public void dfs(int idx, boolean[] visited, int sheepCnt, int wolfCnt) {
        visited[idx] = true;
        if (gInfo[idx] == 0) {
            sheepCnt++;
            if (sheepCnt > maxSheepCnt) {
                maxSheepCnt = sheepCnt;
            }
        } else {
            wolfCnt++;
        }

        if (sheepCnt <= wolfCnt) {
            return;
        }

        for (int[] edge : gEdges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] nextVisited = new boolean[visited.length];
                for (int i = 0; i < visited.length; i++) {
                    nextVisited[i] = visited[i];
                }
                dfs(edge[1], nextVisited, sheepCnt, wolfCnt);
            }
        }
    }
}