package test262;
// 투포/백준/골드5/17609 회문

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String[] arr;

    public static void main(String[] args) throws IOException {
        init();
        StringBuilder answer = new StringBuilder();
        for (String str : arr) {
            answer.append(getAnswer(str, false)).append(lineSeparator());
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        br.close();
    }

    private static int getAnswer(String str, boolean check) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                if (check) {
                    return 2;
                } else {
                    return Math.min(
                        getAnswer(str.substring(l, r), true),
                        getAnswer(str.substring(l + 1, r + 1), true)
                    );
                }
            }
        }
        if (check) {
            return 1;
        }
        return 0;
    }
}
