package test193;
// 백준/골드3/14658 하늘에서 별똥별이 빗발친다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int l = Integer.parseInt(line[2]);
        int k = Integer.parseInt(line[3]);

        int[][] stars = new int[k][2];
        for (int i = 0; i < k; i++) {
            line = br.readLine().split(" ");
            stars[i] = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1])};
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int ct = 0;
                int tx = stars[i][0];
                int ty = stars[j][1];

                for (int[] star : stars) {
                    if (!isBound(tx, ty, star[0], star[1], l)) {
                        ct++;
                    }
                }

                answer = Math.min(ct, answer);
            }
        }

        System.out.println(answer);
    }

    public static boolean isBound(int tx, int ty, int sx, int sy, int l) {
        return sx >= tx && sx <= tx + l && sy >= ty && sy <= ty + l;
    }
}