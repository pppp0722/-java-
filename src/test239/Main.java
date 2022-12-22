package test239;
// 그리디/백준/골드3/3165 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final char FIVE = '5';
    private static StringBuilder n;
    private static int k;

    public static void main(String[] args) throws IOException {
        init();
        backtrack(0, false);
        addRemaining();
        System.out.println(new StringBuilder(n).reverse());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = new StringBuilder(String.valueOf(Long.parseLong(st.nextToken()) + 1))
            .reverse();
        k = Integer.parseInt(st.nextToken());
        br.close();
    }

    private static void backtrack(int idx, boolean flag) {
        if (idx >= n.length() || count() >= k) {
            return;
        }

        if (flag) {
            n.setCharAt(idx - 1, FIVE);
        }

        if (count() >= k) {
            return;
        }

        if (n.charAt(idx) < FIVE) {
            n.setCharAt(idx, FIVE);
            backtrack(idx + 1, false);
        } else if (n.charAt(idx) > FIVE) {
            n.setCharAt(idx, '0');
            roundUp(idx);
            backtrack(idx + 1, true);
        } else {
            backtrack(idx + 1, false);
        }
    }

    private static int count() {
        int ct = 0;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == FIVE) {
                ct++;
            }
        }
        return ct;
    }

    private static void roundUp(int idx) {
        long add = 10;
        for (int i = 0; i < idx; i++) {
            add *= 10;
        }
        n = new StringBuilder(String.valueOf(Long.parseLong(n.reverse().toString()) + add))
            .reverse();
    }

    private static void addRemaining() {
        int ct = count();
        for (int i = ct; i < k; i++) {
            n.append(FIVE);
        }
    }
}