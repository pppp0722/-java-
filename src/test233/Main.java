package test233;
// 그리디/백준/실버4/1026 보물

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] asc = new int[n];
        Integer[] desc = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            asc[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            desc[i] = Integer.parseInt(st.nextToken());
        }

        // 그리디
        Arrays.sort(asc);
        Arrays.sort(desc, Comparator.reverseOrder());
        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += asc[i] * desc[i];
        }

        System.out.println(answer);
    }
}
