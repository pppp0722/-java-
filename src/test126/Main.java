package test126;
// 백준/골드4/1062 가르침

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static Set<Character> learned = new HashSet<>();
    static char[] alphabets = {'b', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'o', 'p', 'q',
        'r', 's', 'u', 'v', 'w', 'x', 'y', 'z'};
    static int N;
    static int K;
    static String[] words;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");
        N = Integer.parseInt(split[0]);
        words = new String[N];
        K = Integer.parseInt(split[1]) - 5;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            StringBuilder word = new StringBuilder();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') {
                    continue;
                }

                word.append(c);
            }

            words[i] = word.toString();
        }

        if (K < 0) {
            System.out.println(0);

            return;
        }

        dfs(0, -1);

        System.out.println(max);
    }

    static void dfs(int depth, int lastIdx) {
        if (depth == K) {
            int ct = 0;
            for (String word : words) {
                boolean contains = true;
                for (int i = 0; i < word.length(); i++) {
                    if (!learned.contains(word.charAt(i))) {
                        contains = false;

                        break;
                    }
                }
                if (contains) {
                    ct++;
                }
            }

            if (ct > max) {
                max = ct;
            }
        }

        for (int i = lastIdx + 1; i < alphabets.length; i++) {
            char c = alphabets[i];
            learned.add(c);
            dfs(depth + 1, i);
            learned.remove(c);
        }
    }
}
