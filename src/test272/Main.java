package test272;
// 그리디/백준/골드4/2258 정육점

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int m;
    private static List<Meat> meats;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMinCost());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        meats = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            meats.add(new Meat(w, c));
        }
        br.close();
    }

    private static int findMinCost() {
        long minCost = Long.MAX_VALUE;

        meats.sort((m1, m2) -> {
            if (m1.c == m2.c) {
                return Long.compare(m2.w, m1.w);
            }
            return Long.compare(m1.c, m2.c);
        });

        int totalW = 0;
        int totalC = 0;
        int preC = 0;
        for (Meat meat : meats) {
            if (meat.c > preC) {
                totalC = 0;
            }

            totalW += meat.w;
            totalC += meat.c;

            if (totalW >= m) {
                minCost = Math.min(totalC, minCost);
            }

            preC = meat.c;
        }

        return minCost == Long.MAX_VALUE ? -1 : (int) minCost;
    }
}

class Meat {

    public int w;
    public int c;

    public Meat(int w, int c) {
        this.w = w;
        this.c = c;
    }
}
