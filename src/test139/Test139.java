package test139;
// 프로그래머스/Level3/외벽 점검

import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean[] visited;
    int[] dist;
    int answer;
    List<Integer> workers = new ArrayList<>();

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        int weakLen = weak.length;
        int distLen = dist.length;
        visited = new boolean[distLen];
        answer = distLen + 1;

        // 원형 벽을 고려하기 위해 week 을 1씩 shift
        for (int i = 0; i < weakLen; i++) {
            int[] shiftWeek = new int[weakLen];
            for (int j = 0; j < weakLen - i; j++) {
                shiftWeek[j] = weak[j + i];
            }
            for (int j = weakLen - i; j < weakLen; j++) {
                shiftWeek[j] = weak[j + i - weakLen] + n;
            }

            // 1명부터 최대 인원까지 DFS
            for (int j = 1; j <= distLen; j++) {
                dfs(0, j, shiftWeek);
                if (j >= answer) {
                    break;
                }
            }
        }

        // 고칠 수 없는 경우 -1 출력
        return answer == distLen + 1 ? -1 : answer;
    }

    void dfs(int depth, int maxDepth, int[] weak) {
        // 순열이 완성되면 모든 벽을 고칠 수 있는지 확인
        if (depth == maxDepth) {
            // 고칠 수 있으면 정답 갱신
            if (canFixAll(weak)) {
                answer = Math.min(depth, answer);
            }

            return;
        }

        // 이번 DFS의 최대 인원까지 모든 순열을 찾아 workers에 add
        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            workers.add(i);
            dfs(depth + 1, maxDepth, weak);
            workers.remove(workers.size() - 1);
            visited[i] = false;
        }
    }

    boolean canFixAll(int[] weak) {
        int idx = -1;
        // 일꾼 한명 씩 벽을 고침
        for (int worker : workers) {
            int d = weak[idx + 1] + dist[worker];
            // 새로 고칠 벽부터 마지막 벽까지
            for (int i = idx + 1; i < weak.length; i++) {
                // 고칠 수 있는 거리면 idx 교체, 고칠 수 없으면 break
                if (weak[i] <= d) {
                    idx = i;
                } else {
                    break;
                }
            }
        }

        if (idx == weak.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}

public class Test139 {

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        int[] dist = {1, 2, 3, 4};
        int answer = new Solution().solution(n, weak, dist);
        System.out.println(answer);
    }
}
