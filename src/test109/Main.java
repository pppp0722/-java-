package test109;
// 백준/실버2/18870 좌표 압축

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        int[] tmpArr = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr[index] = num;
            tmpArr[index] = num;
            index++;
        }

        Arrays.sort(tmpArr);

        Map<Integer, Integer> map = new HashMap<>();
        int ct = 0;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(tmpArr[i])) {
                map.put(tmpArr[i], ct++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(map.get(arr[i]) + " ");
        }

        System.out.println(sb);
    }
}
