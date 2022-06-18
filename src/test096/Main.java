package test096;
// 백준/골드3/9466번 텀 프로젝트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] infos = new int[N][];
        for (int i = 0; i < N; i++) {
            br.readLine();
            infos[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(findNumOfNotCircle(infos[i]));
        }
    }

    public static int findNumOfNotCircle(int[] info) {
        boolean[] visited = new boolean[info.length];
        boolean[] finished = new boolean[info.length];
        int numOfCircle = 0;
        for (int i = 0; i < info.length; i++) {
            if (visited[i]) {
                continue;
            }

            Stack<Integer> stack = new Stack<>();
            int idx = i;
            while (true) {
                if (visited[idx]) {
                    if (!finished[idx]) {
                        while (true) {
                            int popped = stack.pop();
                            finished[popped] = true;
                            numOfCircle++;
                            if (popped == idx) {
                                break;
                            }
                        }
                    }

                    while (!stack.isEmpty()) {
                        int popped = stack.pop();
                        finished[popped] = true;
                    }

                    break;
                }

                visited[idx] = true;
                stack.push(idx);
                idx = info[idx] - 1;
            }
        }

        return info.length - numOfCircle;
    }
}
