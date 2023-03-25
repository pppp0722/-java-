package test273;
// 구현/백준/골드5/20055 컨베이어 벨트 위의 로봇

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;
    private static LinkedList<Belt> belts;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findStepWhenDone());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        belts = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belts.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        br.close();
    }

    private static int findStepWhenDone() {
        int step = 0;
        int ct = 0;
        while (ct < k) {
            step++;

            // 1. 회전
            belts.addFirst(belts.getLast());
            belts.removeLast();
            belts.get(n - 1).isRobot = false;

            // 2. 이동
            for (int i = n - 2; i > 0; i--) {
                Belt curBelt = belts.get(i);
                Belt nextBelt = belts.get(i + 1);
                if (curBelt.isRobot && !nextBelt.isRobot && nextBelt.health > 0) {
                    curBelt.isRobot = false;
                    nextBelt.health--;
                    if (nextBelt.health < 1) {
                        ct++;
                    }
                    if (i != n - 2) {
                        nextBelt.isRobot = true;
                    }
                }
            }

            // 3. 올리기
            Belt initBelt = belts.get(0);
            if (initBelt.health > 0) {
                initBelt.isRobot = true;
                initBelt.health--;
                if (initBelt.health < 1) {
                    ct++;
                }
            }
        }

        return step;
    }
}

class Belt {

    public int health;
    public boolean isRobot;

    public Belt(int health) {
        this.health = health;
        isRobot = false;
    }
}