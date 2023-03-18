package test264;
// 구현/백준/실버4/12873 기념품

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int n;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findWinner());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        br.close();
    }

    private static int findWinner() {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int cur = 0;
        for (int i = 1; i < n; i++) {
            int loser = (int)(((long) Math.pow(i, 3) + cur - 1) % list.size());
            if (loser == list.size() - 1) {
                cur = 0;
            } else {
                cur = loser;
            }
            list.remove(loser);
        }

        return list.get(0);
    }
}
