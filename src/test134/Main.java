package test134;
// 백준/골드4/15683 감시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CCTV {

    private int number;
    private int x;
    private int y;
    private int rotate;

    public CCTV(int number, int x, int y) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }
}

public class Main {

    static int N;
    static int M;
    static int[][] office;
    static List<CCTV> cctvList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number >= 1 && number <= 5) {
                    cctvList.add(new CCTV(number, i, j));
                }
                office[i][j] = number;
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == cctvList.size()) {
            monitor();
            return;
        }

        for (int i = 0; i < 4; i++) {
            cctvList.get(depth).setRotate(i);
            dfs(depth + 1);
        }
    }

    static void monitor() {
        int[][] tmpOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmpOffice[i][j] = office[i][j];
            }
        }

        for (int i = 0; i < cctvList.size(); i++) {
            CCTV cctv = cctvList.get(i);
            int[][] directions = getDirections(cctv.getNumber(), cctv.getRotate());
            for (int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                int x = cctv.getX();
                int y = cctv.getY();
                while (!isOOB(x + dx, y + dy)) {
                    x += dx;
                    y += dy;

                    if (tmpOffice[x][y] == 6) {
                        break;
                    }

                    if (tmpOffice[x][y] == 0) {
                        tmpOffice[x][y] = -1;
                    }
                }
            }
        }

        answer = Math.min(getNumOfBlindSpots(tmpOffice), answer);
    }

    static int[][] getDirections(int number, int rotate) {
        int[][] directions;

        if (number == 1) {
            directions = new int[][]{{0, 1}};
        } else if (number == 2) {
            directions = new int[][]{{0, 1}, {0, -1}};
        } else if (number == 3) {
            directions = new int[][]{{-1, 0}, {0, 1}};
        } else if (number == 4) {
            directions = new int[][]{{-1, 0}, {0, 1}, {0, -1}};
        } else {
            directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        }

        for (int i = 0; i < rotate; i++) {
            for (int j = 0; j < directions.length; j++) {
                int dx = directions[j][0];
                int dy = directions[j][1];
                if (dx == -1 && dy == 0) {
                    directions[j][0] = 0;
                    directions[j][1] = 1;
                } else if (dx == 0 && dy == 1) {
                    directions[j][0] = 1;
                    directions[j][1] = 0;
                } else if (dx == 1 && dy == 0) {
                    directions[j][0] = 0;
                    directions[j][1] = -1;
                } else {
                    directions[j][0] = -1;
                    directions[j][1] = 0;
                }
            }
        }

        return directions;
    }

    static boolean isOOB(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return true;
        }

        return false;
    }

    static int getNumOfBlindSpots(int[][] office) {
        int numOfBlindSpots = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) {
                    numOfBlindSpots++;
                }
            }
        }

        return numOfBlindSpots;
    }
}