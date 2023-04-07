package test291;
// 문자열,정렬/백준/골드5/5052 전화번호 목록

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phones = new String[n];

            for (int j = 0; j < n; j++) {
                phones[j] = br.readLine();
            }

            Arrays.sort(phones);
            boolean check = true;

            for (int j = 0; j < n - 1; j++) {
                String phone1 = phones[j];
                String phone2 = phones[j + 1];
                int len = Math.min(phone1.length(), phone2.length());

                if (phone1.substring(0, len).equals(phone2.substring(0, len))) {
                    check = false;
                    break;
                }
            }

            answer.append(check ? "YES" : "NO").append(lineSeparator());
        }

        System.out.print(answer);
    }
}