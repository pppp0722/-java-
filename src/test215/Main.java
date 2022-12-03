package test215;
// 구현/백준/골드4/3190 뱀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int n;
    private static int k;
    private static int l;
    private static boolean[][] apple;
    private static Map<Integer, Character> command;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(findEndTime());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        apple = new boolean[n + 1][n + 1];
        command = new HashMap<>();
        for (int i = 0; i < k; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            apple[x][y] = true;
        }
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            char c = line[1].charAt(0);
            command.put(x, c);
        }
        br.close();
    }

    private static int findEndTime() {
        // 초기화
        int time = 0;
        Snake snake = new Snake();
        List<Position> positions = new ArrayList<>(); // 자신과 부딪히는 경우 위해 경로 저장
        positions.add(new Position(1, 1)); // 시작 위치

        // 탐색
        while (true) {
            time++;
            snake.move();

            // 게임 종료 상황이면 break
            if (isGameOver(snake, time, positions)) {
                break;
            }

            Position p = snake.getPos();
            int x = p.getX();
            int y = p.getY();

            // 사과 먹으면 길이 증가
            if (apple[x][y]) {
                snake.growUp();
                apple[x][y] = false;
            }

            // 커맨드 있으면 방향 전환
            if (command.containsKey(time)) {
                snake.rotate(command.get(time));
            }

            // 현재 위치 경로에 저장
            positions.add(new Position(x, y));
        }

        return time;
    }

    private static boolean isGameOver(Snake snake, int time, List<Position> positions) {
        Position pos = snake.getPos();
        int x = pos.getX();
        int y = pos.getY();

        // 벽에 부딪히면 게임오버
        if (x < 1 || x > n || y < 1 || y > n) {
            return true;
        }

        // 자신과 부딪히면 게임오버
        for (int i = time - 1; i >= time - snake.getLen(); i--) {
            Position prePos = positions.get(i);
            if (x == prePos.getX() && y == prePos.getY()) {
                return true;
            }
        }

        return false;
    }
}

class Snake {

    private Position pos;
    private int dir; // 0 : U, 1 : R, 2 : D, 3 : L
    private int len;

    public Snake() {
        pos = new Position(1, 1);
        dir = 1;
        len = 1;
    }

    public Position getPos() {
        return pos;
    }

    public int getLen() {
        return len;
    }

    public void growUp() {
        len++;
    }

    public void rotate(char c) {
        switch (dir) {
            case 0:
                dir = c == 'L' ? 3 : 1;
                break;
            case 1:
                dir = c == 'L' ? 0 : 2;
                break;
            case 2:
                dir = c == 'L' ? 1 : 3;
                break;
            default:
                dir = c == 'L' ? 2 : 0;
                break;
        }
    }

    public void move() {
        int x = pos.getX();
        int y = pos.getY();
        switch (dir) {
            case 0:
                pos.setX(x - 1);
                break;
            case 1:
                pos.setY(y + 1);
                break;
            case 2:
                pos.setX(x + 1);
                break;
            default:
                pos.setY(y - 1);
                break;
        }
    }
}

class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}