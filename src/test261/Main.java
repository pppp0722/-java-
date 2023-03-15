package test261;
// DP/백준/골드2/3687 성냥개비

import static java.lang.System.lineSeparator;
import static java.util.Objects.isNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int[] costs = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    private static int n;
    private static int[] arr;
    private static int maxInput = 0;

    public static void main(String[] args) throws IOException {
        init();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] minAndMax = findMinAndMax(i);
            answer.append(minAndMax[0]).append(" ").append(minAndMax[1]).append(lineSeparator());
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxInput = Math.max(arr[i], maxInput);
        }
        br.close();
    }

    private static String[] findMinAndMax(int idx) {
        int num = arr[idx];
        String[] min = new String[num + 1];
        min[0] = "";
        String[] max = new String[num + 1];
        max[0] = "";

        // min 구하기
        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < costs.length; j++) {
                if (i == 6 && j == 0) {
                    continue;
                }
                int preIdx = i - costs[j];
                if (preIdx >= 0 && !isNull(min[preIdx])) {
                    String cur = min[preIdx] + j;
                    if (isNull(min[i])) {
                        min[i] = cur;
                    } else {
                        if (cur.length() < min[i].length()
                            || (cur.length() == min[i].length() && cur.compareTo(min[i]) < 0)) {
                            min[i] = cur;
                        }
                    }
                }
            }
        }

        // max 구하기
        for (int i = 2; i <= num; i++) {
            for (int j = 0; j < costs.length; j++) {
                if (i == 6 && j == 0) {
                    continue;
                }
                int preIdx = i - costs[j];
                if (preIdx >= 0 && !isNull(max[preIdx])) {
                    String cur = max[preIdx] + j;
                    if (isNull(max[i])) {
                        max[i] = cur;
                    } else {
                        if (cur.length() > max[i].length()
                            || (cur.length() == max[i].length() && cur.compareTo(max[i]) > 0)) {
                            max[i] = cur;
                        }
                    }
                }
            }
        }

        return new String[]{min[num], max[num]};
    }
}
