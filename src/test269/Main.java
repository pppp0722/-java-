package test269;
// 그리디/백준/골드4/2141 우체국

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static Town[] towns;
    private static long totalPopulation;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findLocation());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        towns = new Town[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            towns[i] = new Town(x, a);
            totalPopulation += a;
        }
        br.close();
    }

    private static int findLocation() {
        Arrays.sort(towns);
        int location = towns[n - 1].x;
        long population = 0;
        for (int i = 0; i < n; i++) {
            Town town = towns[i];
            population += town.a;
            if (population >= (totalPopulation + 1) / 2) {
                location = town.x;
                break;
            }
        }
        return location;
    }
}

class Town implements Comparable<Town> {

    public int x;
    public int a;

    public Town(int x, int a) {
        this.x = x;
        this.a = a;
    }

    @Override
    public int compareTo(Town o) {
        if (x == o.x) {
            return a - o.a;
        } else {
            return x - o.x;
        }
    }
}
