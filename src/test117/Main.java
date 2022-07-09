package test117;
// 백준/실버2/1541 잃어버린 괄호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int result = 0;
        String numStr = "";
        boolean minus = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                numStr += c;
            } else {
                int num = Integer.parseInt(numStr);
                result = minus ? result - num : result + num;

                numStr = "";

                if (c == '-') {
                    minus = true;
                }
            }
        }

        int num = Integer.parseInt(numStr);
        result = minus ? result - num : result + num;

        System.out.println(result);
    }
}
