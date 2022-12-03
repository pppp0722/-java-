package test213;
// 완탐/백준/골드3/1941 소문난 칠공주

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    private static final int[] DX = {-1, 0, 1, 0};
    private static final int[] DY = {0, 1, 0, -1};
    private static final int N = 5;
    private static final int SIZE = 7;
    private static char[] map = new char[N * N];
    private static Set<Integer> set = new HashSet<>();
    private static int sCount = 0;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[N * i + j] = line.charAt(j);
            }
        }

        // 완탐
        findAnswer();

        System.out.println(answer);
    }

    private static void findAnswer() {
        // 이다솜파 설정
        setS(0, 0, false);
    }

    private static void setS(int depth, int idx, boolean flag) {
        // 이전에 이다솜파 선택했고(중복 방지) 이다솜파 4명 이상 선택했을 때 임도연파 설정
        if (flag && sCount > SIZE / 2) {
            setY(depth, 0);
        }

        if (depth == SIZE || idx == N * N) {
            return;
        }

        setS(depth, idx + 1, false); // 선택 X
        if (map[idx] == 'S') { // 이다솜파 선택
            set.add(idx);
            sCount++;
            setS(depth + 1, idx + 1, true);
            set.remove(idx);
            sCount--;
        }
    }

    private static void setY(int depth, int idx) {
        // 7명 모두 선택했으면 모두 인접했는지 check
        if (depth == SIZE) {
            if (check()) {
                answer++;
            }
            return;
        }

        if (idx == N * N) {
            return;
        }

        setY(depth, idx + 1); // 선택 X
        if (map[idx] == 'Y') { // 임도연파 선택
            set.add(idx);
            setY(depth + 1, idx + 1);
            set.remove(idx);
        }
    }

    private static boolean check() {
        for (int i = 0; i < N * N; i++) {
            // 선택한 인덱스 발견하면 BFS 후 break
            if (set.contains(i)) {
                // BFS 초기화
                int initX = i / N;
                int initY = i % N;
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visited = new boolean[N][N];
                q.offer(new int[]{initX, initY});
                visited[initX][initY] = true;
                int ct = 0;

                // BFS
                while (!q.isEmpty()) {
                    int[] cp = q.poll();
                    int cx = cp[0];
                    int cy = cp[1];

                    ct++;

                    for (int j = 0; j < 4; j++) {
                        int nx = cx + DX[j];
                        int ny = cy + DY[j];

                        if (isOOB(nx, ny) || visited[nx][ny]) {
                            continue;
                        }

                        // 선택한 인덱스면 큐에 넣어줌
                        if (set.contains(N * nx + ny)) {
                            q.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }

                // 7명 모두 인접하면 true
                if (ct == SIZE) {
                    return true;
                }

                break;
            }
        }

        return false;
    }

    private static boolean isOOB(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }
        return false;
    }
}
