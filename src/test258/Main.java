package test258;
// 이탐,그리디/백준/골드1/1508 레이스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;
    private static int k;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(binarySearch());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    private static String binarySearch() {
        String answer = "";
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = (l + r) / 2;
            String referees = setReferee(m);
            if ("-1".equals(referees)) {
                r = m - 1;
            } else {
                l = m + 1;
                answer = referees;
            }
        }
        return answer;
    }

    private static String setReferee(int dist) {
        StringBuilder sb = new StringBuilder();
        int ct = 1;
        sb.append("1");
        int lastIdx = arr[0];
        for (int i = 1; i < k; i++) {
            int curIdx = arr[i];
            if (curIdx - lastIdx < dist) {
                sb.append("0");
            } else {
                sb.append("1");
                lastIdx = curIdx;
                ct++;
            }
            if (ct == m) {
                sb.append("0".repeat(k - i - 1));
                break;
            }
        }
        return ct == m ? sb.toString() : "-1";
    }
}