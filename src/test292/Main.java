package test292;
// 문자열/백준/실버1/5525 IOIOI

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;
        int i = 0;
        int ct = 0;

        while (i < m - 2) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                ct++;

                if (ct == n) {
                    ct--;
                    answer++;
                }

                i++;
            } else {
                ct = 0;
            }

            i++;
        }

        System.out.println(answer);
    }
}
