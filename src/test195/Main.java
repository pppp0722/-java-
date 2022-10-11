package test195;
// 백준/실버4/1120 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String lStr = line[0];
        String rStr = line[1];

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= rStr.length() - lStr.length(); i++) {
            int mismatch = 0;
            for (int j = 0; j < lStr.length(); j++) {
                if (lStr.charAt(j) != rStr.charAt(j + i)) {
                    mismatch++;
                }
            }
            answer = Math.min(mismatch, answer);
        }

        System.out.println(answer);
    }
}