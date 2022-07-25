package test144;
// 프로그래머스/Level2/거리두기 확인하기

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            answer[i] = bfs(places[i]);
        }

        return answer;
    }

    int bfs(String[] place) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q1 = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i].charAt(j) == 'P') {
                    q1.offer(new int[]{i, j, 0});
                }
            }
        }

        Queue<int[]> q2 = new LinkedList<>();
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
            while (!q2.isEmpty()) {
                int[] cur = q2.poll();
                int x = cur[0];
                int y = cur[1];
                visited[x][y] = true;

                if (cur[2] != 0 && place[x].charAt(y) == 'P') {
                    return 0;
                }

                if (cur[2] == 2) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    if (!isOOB(nx, ny) && !visited[nx][ny]) {
                        if (place[nx].charAt(ny) == 'X') {
                            continue;
                        }

                        q2.offer(new int[]{nx, ny, cur[2] + 1});
                    }
                }
            }
        }

        return 1;
    }

    boolean isOOB(int x, int y) {
        if (x < 0 || x >= 5 || y < 0 || y >= 5) {
            return true;
        }

        return false;
    }
}

public class Test144 {

}
