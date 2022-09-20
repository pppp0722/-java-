package test187;
// 백준/골드3/14890 경사로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int l = Integer.parseInt(line[1]);
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int h = map[i][0];
            boolean check = true;
            int support = 0;
            for (int j = 0; j < n; j++) {
                int cur = map[i][j];

                if (support > 0) { // 아직 경사로가 남았을 때
                    if (cur != h) {
                        check = false;
                        break;
                    }
                    support--;
                } else { // 경사로 없을 때
                    if (cur == h - 1) {
                        if (j + l > n) {
                            check = false;
                            break;
                        }
                        h--;
                        support = l - 1;
                    } else if (cur == h + 1) {
                        if (-support < l) {
                            check = false;
                            break;
                        }
                        h++;
                        support = -1;
                    } else if (cur != h) {
                        check = false;
                        break;
                    } else {
                        support--;
                    }
                }
            }

            if (check) {
                answer++;
            }

            h = map[0][i];
            check = true;
            support = 0;
            for (int j = 0; j < n; j++) {
                int cur = map[j][i];

                if (support > 0) { // 아직 경사로가 남았을 때
                    if (cur != h) {
                        check = false;
                        break;
                    }
                    support--;
                } else { // 경사로 없을 때
                    if (cur == h - 1) {
                        if (j + l > n) {
                            check = false;
                            break;
                        }
                        h--;
                        support = l - 1;
                    } else if (cur == h + 1) {
                        if (-support < l) {
                            check = false;
                            break;
                        }
                        h++;
                        support = -1;
                    } else if (cur != h) {
                        check = false;
                        break;
                    } else {
                        support--;
                    }
                }
            }

            if (check) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
