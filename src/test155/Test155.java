package test155;
// 프로그래머스/Level2/게임 맵 최단거리

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int N;
    int M;
    int[][] maps;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        this.maps = maps;

        return bfs();
    }

    int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!isOOB(nx, ny) && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }

        return -1;
    }

    boolean isOOB(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return true;
        }

        return false;
    }
}

public class Test155 {

}
