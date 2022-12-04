package test216;
// 정규식/백준/골드5/1013 Contact

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern PATTERN = Pattern.compile("(100+1+|01)+");
    private static int n;
    private static String[] inputs;

    public static void main(String[] args) throws IOException {
        init();
        print();
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inputs = new String[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = br.readLine();
        }
        br.close();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String yN = isMatch(inputs[i]) ? "YES" : "NO";
            sb.append(yN).append(lineSeparator());
        }
        System.out.println(sb);
    }

    private static boolean isMatch(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }
}
