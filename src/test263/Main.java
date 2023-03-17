package test263;
// 투포/백준/골드2/2632 피자판매

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static List<Integer> aList;
    private static List<Integer> bList;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findAllNumOfCases());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] aArr = new int[a];
        int[] bArr = new int[b];
        for (int i = 0; i < a; i++) {
            aArr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < b; i++) {
            bArr[i] = Integer.parseInt(br.readLine());
        }
        aList = new ArrayList<>();
        bList = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            boolean[] visited = new boolean[a];
            visited[i] = true;
            getSum(aArr[i], i, i + 1, aArr, aList, visited);
        }
        for (int i = 0; i < b; i++) {
            boolean[] visited = new boolean[b];
            visited[i] = true;
            getSum(bArr[i], i, i + 1, bArr, bList, visited);
        }
        aList.add(0);
        bList.add(0);
        br.close();
    }

    private static void getSum(int sum, int startIdx, int idx, int[] arr, List<Integer> list,
        boolean[] visited) {
        if (idx == arr.length) {
            idx = 0;
        }

        list.add(sum);

        if (!visited[idx] && sum + arr[idx] <= n && idx != startIdx - 1) {
            visited[idx] = true;
            getSum(sum + arr[idx], startIdx, idx + 1, arr, list, visited);
        }
    }

    private static int findAllNumOfCases() {
        int allNumOfCases = 0;

        aList.sort(Comparator.naturalOrder());
        bList.sort(Comparator.naturalOrder());

        int l = 0;
        int r = bList.size() - 1;
        while (l < aList.size() && r >= 0) {
            int lv = aList.get(l);
            int rv = bList.get(r);

            if (lv + rv == n) {
                int lc = 0;
                int rc = 0;

                while (l < aList.size() && aList.get(l) == lv) {
                    lc++;
                    l++;
                }
                while (r >= 0 && bList.get(r) == rv) {
                    rc++;
                    r--;
                }

                allNumOfCases += lc * rc;
            } else if (lv + rv < n) {
                l++;
            } else {
                r--;
            }
        }

        return allNumOfCases;
    }
}