package test210;
// 시뮬/백준/골드5/14503 로봇 청소기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;
    private static int m;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        line = br.readLine().split(" ");
        int initX = Integer.parseInt(line[0]);
        int initY = Integer.parseInt(line[1]);
        int initD = Integer.parseInt(line[2]);
        for (int x = 0; x < n; x++) {
            line = br.readLine().split(" ");
            for (int y = 0; y < m; y++) {
                map[x][y] = Integer.parseInt(line[y]);
            }
        }

        // 탐색 시작
        Robot robot = new Robot(initX, initY, initD);
        int answer = 0;
        while (true) {
            // 방문
            if (!visited[robot.x][robot.y]) {
                answer++;
                visited[robot.x][robot.y] = true;
            }

            // 조건에 따라
            if (isAllDirClean(robot)) { // 모든 방향 깨끗하면
                if (!canBack(robot)) { // 뒤로 움직일 수 없으면 break
                    break;
                }
                robot.back(); // 로봇 뒤로 후진
                robot.ct = 0;
            } else if (isLeftUnclean(robot)) { // 왼쪽 방향 깨끗하지 않으면 회전하고 이동, ct 초기화
                robot.rotate();
                robot.move();
                robot.ct = 0;
            } else { // 왼쪽 방향 깨끗하면 회전, ct 증가
                robot.rotate();
                robot.ct++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isAllDirClean(Robot robot) {
        return robot.ct == 4;
    }

    private static boolean isLeftUnclean(Robot robot) {
        int nx = robot.x;
        int ny = robot.y;
        switch (robot.d) {
            case 0:
                ny--;
                break;
            case 1:
                nx--;
                break;
            case 2:
                ny++;
                break;
            default: // 3
                nx++;
                break;
        }

        if (!isOOB(nx, ny) && !visited[nx][ny]) {
            return true;
        }
        return false;
    }

    private static boolean canBack(Robot robot) {
        switch (robot.d) {
            case 0:
                return !isOOB(robot.x + 1, robot.y);
            case 1:
                return !isOOB(robot.x, robot.y - 1);
            case 2:
                return !isOOB(robot.x - 1, robot.y);
            default: // 3
                return !isOOB(robot.x, robot.y + 1);
        }
    }

    private static boolean isOOB(int x, int y) {
        if (map[x][y] == 1) {
            return true;
        }
        return false;
    }
}

class Robot {

    public int x;
    public int y;
    public int d; // 0 : u, 1 : r, 2: d, 3: l
    public int ct;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
        ct = 0;
    }

    public void rotate() {
        switch (d) {
            case 0:
                d = 3;
                break;
            case 1:
                d = 0;
                break;
            case 2:
                d = 1;
                break;
            default: // 3
                d = 2;
                break;
        }
    }

    public void move() {
        switch (d) {
            case 0:
                x--;
                break;
            case 1:
                y++;
                break;
            case 2:
                x++;
                break;
            default: // 3
                y--;
                break;
        }
    }

    public void back() {
        switch (d) {
            case 0:
                x++;
                break;
            case 1:
                y--;
                break;
            case 2:
                x--;
                break;
            default: // 3
                y++;
                break;
        }
    }
}