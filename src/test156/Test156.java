package test156;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

    int N;
    int K;
    int[] gpsLog;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int answer;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        N = n;
        K = k;
        gpsLog = gps_log;
        for (int i = 0; i < m; i++) {
            int[] edge = edge_list[i];
            int key1 = edge[0];
            int key2 = edge[1];
            List<Integer> value1 = map.getOrDefault(key1, new ArrayList<>());
            value1.add(key2);
            map.put(key1, value1);
            List<Integer> value2 = map.getOrDefault(key2, new ArrayList<>());
            value1.add(key1);
            map.put(key2, value2);
        }

        return answer;
    }

    void bfs() {
        int ck = gpsLog[0];
        int idx = 1;
        while (idx < K) {
            int nk = gpsLog[idx];
            if (ck != nk && !map.get(ck).contains(nk)) {
                boolean[] visited = new boolean[N + 1];
                Queue<int[]> q = new LinkedList<>();
                visited[ck] = true;
                q.offer(new int[]{ck, idx - 1});

                boolean isFixed = false;
                while (q.isEmpty()) {
                    int[] cur = q.poll();
                    idx = cur[1];

                    if (cur[0] == gpsLog[idx]) {
                        isFixed = true;
                        break;
                    }

                    for (int next : map.get(cur)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            q.offer(new int[]{next, cur[1] + 1});
                        }
                    }
                }

                if (!isFixed) {
                    answer = -1;
                    break;
                }
            }

            ck = nk;
            idx++;
        }
    }
}

public class Test156 {

    public static void main(String[] args) {
        int n = 7;
        int m = 10;
        int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7},
            {6, 7}};
        int k = 6;
        int[] gps_log = {1, 2, 3, 3, 6, 7};
        int answer = new Solution().solution(n, m, edge_list, k, gps_log);
        System.out.println(answer);
    }
}
