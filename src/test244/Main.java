package test244;
// 시뮬/백준/골드1/17143 낚시왕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;
    private static int M;
    private static Shark[][] sharks;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findSumOfSizes());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new Shark[R + 1][C + 1];
        int r, c, s, d, z;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            sharks[r][c] = new Shark(r, c, s, d, z);
        }
        br.close();
    }

    private static int findSumOfSizes() {
        int sum = 0;
        int idx = 0;
        for (int i = 1; i <= C; i++) {
            // 낚시꾼 한칸 이동
            idx++;
            // 상어 잡기
            sum += catchNearestOne(idx);
            // 상어 이동
            move();
        }

        return sum;
    }

    private static int catchNearestOne(int idx) {
        int size = 0;
        for (int i = 1; i <= R; i++) {
            Shark shark = sharks[i][idx];
            if (shark != null) {
                size = shark.z;
                sharks[i][idx] = null;
                break;
            }
        }

        return size;
    }

    private static void move() {
        Shark shark;
        Stack<Shark> stack = new Stack<>();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                shark = sharks[i][j];
                if (shark != null) {
                    shark.move(R, C);
                    stack.push(shark);
                    sharks[i][j] = null;
                }
            }
        }

        Shark preShark;
        while (!stack.isEmpty()) {
            shark = stack.pop();
            preShark = sharks[shark.r][shark.c];
            if (preShark == null || shark.z > preShark.z) {
                sharks[shark.r][shark.c] = shark;
            }
        }
    }
}

class Shark {

    public int r;
    public int c;
    public int s;
    public int d; // 1 : U, 2 : D, 3 : R, 4 : L
    public int z;

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }

    public void move(int R, int C) {
        int customS = s % (((d < 3 ? R : C) - 1) * 2);
        for (int i = 0; i < customS; i++) {
            if (d == 1 && r == 1) {
                d = 2;
            } else if (d == 2 && r == R) {
                d = 1;
            } else if (d == 3 && c == C) {
                d = 4;
            } else if (d == 4 && c == 1) {
                d = 3;
            }

            if (d == 1) {
                r--;
            } else if (d == 2) {
                r++;
            } else if (d == 3) {
                c++;
            } else {
                c--;
            }
        }
    }
}
