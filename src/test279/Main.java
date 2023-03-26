package test279;
// 비트마스킹/백준/실버5/11723 집합

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        // 비트마스킹
        int bitmask = 0b0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if ("all".equals(command)) {
                bitmask = 0b11111111111111111111;
            } else if ("empty".equals(command)) {
                bitmask = 0b00000000000000000000;
            } else {
                int x = Integer.parseInt(st.nextToken()) - 1;

                if ("add".equals(command)) {
                    bitmask |= 0b1 << x;
                } else if ("remove".equals(command)) {
                    bitmask &= ~(0b1 << x);
                } else if ("check".equals(command)) {
                    int result = bitmask & (0b1 << x);
                    answer.append(result == 0 ? 0 : 1).append(lineSeparator());
                } else if ("toggle".equals(command)) {
                    bitmask ^= 0b1 << x;
                }
            }
        }

        System.out.println(answer);
    }
}
