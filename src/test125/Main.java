package test125;
// 백준/골드1/13460 구슬 탈출 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int holeX;
    static int holeY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new char[N][M];
        Marble marble = new Marble();
        marble.ct = 0;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'R') {
                    marble.redX = i;
                    marble.redY = j;
                } else if (c == 'B') {
                    marble.blueX = i;
                    marble.blueY = j;
                } else if (c == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }

        System.out.println(bfs(marble));
    }

    static int bfs(Marble marble) {
        Queue<Marble> q = new LinkedList<>();
        q.offer(marble);
        while (!q.isEmpty()) {
            Marble curMarble = q.poll();
            if (curMarble.ct == 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                Marble nextMarble = curMarble.getNew();
                boolean holeR = false;
                boolean holeB = false;

                while (map[nextMarble.redX + dx[i]][nextMarble.redY + dy[i]] != '#'
                    && map[nextMarble.blueX + dx[i]][nextMarble.blueY + dy[i]] != '#') {
                    nextMarble.redX += dx[i];
                    nextMarble.redY += dy[i];
                    nextMarble.blueX += dx[i];
                    nextMarble.blueY += dy[i];

                    if (nextMarble.redX == holeX && nextMarble.redY == holeY) {
                        holeR = true;
                    }

                    if (nextMarble.blueX == holeX && nextMarble.blueY == holeY) {
                        holeB = true;
                    }
                }

                while (map[nextMarble.redX + dx[i]][nextMarble.redY + dy[i]] != '#') {
                    nextMarble.redX += dx[i];
                    nextMarble.redY += dy[i];

                    if (nextMarble.redX == holeX && nextMarble.redY == holeY) {
                        holeR = true;
                    }
                }

                while (map[nextMarble.blueX + dx[i]][nextMarble.blueY + dy[i]] != '#') {
                    nextMarble.blueX += dx[i];
                    nextMarble.blueY += dy[i];

                    if (nextMarble.blueX == holeX && nextMarble.blueY == holeY) {
                        holeB = true;
                    }
                }

                if (holeB) {
                    continue;
                }

                if (holeR) {
                    return nextMarble.ct;
                }

                if (nextMarble.redX == nextMarble.blueX && nextMarble.redY == nextMarble.blueY) {
                    if (i == 0) {
                        if (curMarble.redX > curMarble.blueX) {
                            nextMarble.redX -= dx[i];
                        } else {
                            nextMarble.blueX -= dx[i];
                        }
                    } else if (i == 1) {
                        if (curMarble.redY < curMarble.blueY) {
                            nextMarble.redY -= dy[i];
                        } else {
                            nextMarble.blueY -= dy[i];
                        }
                    } else if (i == 2) {
                        if (curMarble.redX < curMarble.blueX) {
                            nextMarble.redX -= dx[i];
                        } else {
                            nextMarble.blueX -= dx[i];
                        }
                    } else {
                        if (curMarble.redY > curMarble.blueY) {
                            nextMarble.redY -= dy[i];
                        } else {
                            nextMarble.blueY -= dy[i];
                        }
                    }
                }

                q.offer(nextMarble);
            }
        }

        return -1;
    }
}

class Marble {

    int redX;
    int redY;
    int blueX;
    int blueY;
    int ct;

    Marble getNew() {
        Marble newMarble = new Marble();
        newMarble.redX = this.redX;
        newMarble.redY = this.redY;
        newMarble.blueX = this.blueX;
        newMarble.blueY = this.blueY;
        newMarble.ct = this.ct + 1;

        return newMarble;
    }
}