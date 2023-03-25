package test274;
// 투포인터/백준/골드5/20437 문자열 게임 2

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int l = 0;
            int r = 0;
            int ct = 0;
            int minLen = w.length() + 1;
            int maxLen = 0;
            int[] alpha = new int[26];
            for (int j = 0; j < w.length(); j++) {
                alpha[w.charAt(j) - 'a']++;
            }
            while (l < w.length()) {
                if (alpha[w.charAt(l) - 'a'] < k) {
                    l++;
                    r = l;
                    continue;
                }

                if (w.charAt(l) == w.charAt(r)) {
                    ct++;
                    if (ct == k) {
                        int len = r - l + 1;
                        minLen = Math.min(len, minLen);
                        maxLen = Math.max(len, maxLen);
                        l++;
                        r = l;
                        ct = 0;
                        continue;
                    }
                }
                if (r < w.length() - 1) {
                    r++;
                } else {
                    l++;
                    r = l;
                    ct = 0;
                }
            }
            if (minLen == w.length() + 1) {
                answer.append("-1").append(lineSeparator());
            } else {
                answer.append(minLen).append(" ").append(maxLen).append(lineSeparator());
            }
        }
        System.out.print(answer);
    }
}
