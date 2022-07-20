package test140;
// 프로그래머스/Level3/블록 이동하기

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    int N;
    int[][] map;
    boolean[][][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int answer;


    public int solution(int[][] board) {
        N = board.length;
        map = board;
        visited = new boolean[N][N][2];

        bfs();

        return answer;
    }

    void bfs() {
        Queue<Drone> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.offer(new Drone(0, 0, 0, true));
        while (!q.isEmpty()) {
            Drone drone = q.poll();

            // 도착
            if (isArrived(drone)) {
                answer = drone.depth;
                break;
            }

            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = drone.x + dx[i];
                int ny = drone.y + dy[i];
                int type = drone.horizontal ? 0 : 1;

                if (!canMove(drone, i) || visited[nx][ny][type]) {
                    continue;
                }

                visited[nx][ny][type] = true;
                q.offer(new Drone(nx, ny, drone.depth + 1, drone.horizontal));
            }

            // 회전
            for (int i = 0; i < 4; i++) {
                int[] nextPosition = getNextPosition(drone, i);
                int nx = nextPosition[0];
                int ny = nextPosition[1];
                int type = drone.horizontal ? 1 : 0;

                if (!canRotate(drone, i) || visited[nx][ny][type]) {
                    continue;
                }

                visited[nx][ny][type] = true;
                q.offer(new Drone(nx, ny, drone.depth + 1, !drone.horizontal));
            }
        }
    }

    boolean isArrived(Drone drone) {
        if (drone.x == N - 1 && drone.y == N - 1) {
            return true;
        }
        if (drone.horizontal && drone.x == N - 1 && drone.y + 1 == N - 1) {
            return true;
        }
        if (!drone.horizontal && drone.x + 1 == N - 1 && drone.y == N - 1) {
            return true;
        }

        return false;
    }

    boolean canMove(Drone drone, int dir) {
        int nx = drone.x + dx[dir];
        int ny = drone.y + dy[dir];
        if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1) {
            return false;
        }
        if (drone.horizontal) {
            if (ny + 1 >= N || map[nx][ny + 1] == 1) {
                return false;
            }
        }
        if (!drone.horizontal) {
            if (nx + 1 >= N || map[nx + 1][ny] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean canRotate(Drone drone, int dir) {
        if (drone.horizontal) {
            if (dir == 1 || dir == 2) {
                if (dir == 1) {
                    if (drone.x + 1 >= N || drone.y + 1 >= N) {
                        return false;
                    }
                } else {
                    if (drone.x + 1 >= N || drone.y >= N) {
                        return false;
                    }
                }
                if (map[drone.x + 1][drone.y + 1] == 1 || map[drone.x + 1][drone.y] == 1) {
                    return false;
                }
            } else {
                if (dir == 3) {
                    if (drone.x - 1 < 0 || drone.y + 1 >= N) {
                        return false;
                    }
                } else {
                    if (drone.x - 1 < 0) {
                        return false;
                    }
                }
                if (map[drone.x - 1][drone.y + 1] == 1 || map[drone.x - 1][drone.y] == 1) {
                    return false;
                }
            }
        } else {
            if (dir == 1 || dir == 2) {
                if (dir == 1) {
                    if (drone.y - 1 < 0) {
                        return false;
                    }
                } else {
                    if (drone.x + 1 >= N || drone.y - 1 < 0) {
                        return false;
                    }
                }
                if (map[drone.x][drone.y - 1] == 1 || map[drone.x + 1][drone.y - 1] == 1) {
                    return false;
                }
            } else {
                if (dir == 3) {
                    if (drone.y + 1 >= N) {
                        return false;
                    }
                } else {
                    if (drone.x + 1 >= N || drone.y + 1 >= N) {
                        return false;
                    }
                }
                if (map[drone.x][drone.y + 1] == 1 || map[drone.x + 1][drone.y + 1] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    int[] getNextPosition(Drone drone, int dir) {
        int nx;
        int ny;
        if (drone.horizontal) {
            if (dir == 1) {
                nx = drone.x;
                ny = drone.y;
            } else if (dir == 2) {
                nx = drone.x;
                ny = drone.y + 1;
            } else if (dir == 3) {
                nx = drone.x - 1;
                ny = drone.y;
            } else {
                nx = drone.x - 1;
                ny = drone.y + 1;
            }
        } else {
            if (dir == 1) {
                nx = drone.x;
                ny = drone.y - 1;
            } else if (dir == 2) {
                nx = drone.x + 1;
                ny = drone.y - 1;
            } else if (dir == 3) {
                nx = drone.x;
                ny = drone.y;
            } else {
                nx = drone.x + 1;
                ny = drone.y;
            }
        }

        return new int[]{nx, ny};
    }
}

class Drone {

    public int x;
    public int y;
    public int depth;
    public boolean horizontal = true;

    public Drone(int x, int y, int depth, boolean horizontal) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.horizontal = horizontal;
    }
}

public class Test140 {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0}};
        int answer = new Solution().solution(board);
        System.out.println(answer);
    }
}