package test265;
// 구현/백준/실버2/2932 표 회전

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;
    private static List<Position> positions;

    public static void main(String[] args) throws IOException {
        init();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i++) {
            answer.append(findNumOfRotations(i)).append(lineSeparator());
        }
        System.out.print(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        positions = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            positions.add(new Position(x / n, x % n, r, c));
        }
        br.close();
    }

    private static int findNumOfRotations(int idx) {
        int numOfRotations = 0;

        Position cp = positions.get(idx);
        if (cp.cy != cp.ty) {
            int numOfColRotations = (n + cp.ty - cp.cy) % n;
            for (int i = idx; i < k; i++) {
                Position p = positions.get(i);
                if (p.cx == cp.cx) {
                    p.cy = (p.cy + numOfColRotations) % n;
                }
            }
            numOfRotations += numOfColRotations;
        }
        if (cp.cx != cp.tx) {
            int numOfRowRotations = (n + cp.tx - cp.cx) % n;
            for (int i = idx; i < k; i++) {
                Position p = positions.get(i);
                if (p.cy == cp.cy) {
                    p.cx = (p.cx + numOfRowRotations) % n;
                }
            }
            numOfRotations += numOfRowRotations;
        }

        return numOfRotations;
    }
}

class Position {

    public int cx;
    public int cy;
    public int tx;
    public int ty;

    public Position(int cx, int cy, int tx, int ty) {
        this.cx = cx;
        this.cy = cy;
        this.tx = tx;
        this.ty = ty;
    }
}
