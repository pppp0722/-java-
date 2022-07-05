package test106;
// 프로그래머스/Level3/N으로 표현
class Solution {

    private int n;
    private int target;
    private int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        n = N;
        target = number;

        dfs(0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int depth, int num) {
        if (depth > 8) {
            return;
        }

        if (num == target) {
            answer = Math.min(answer, depth);
            return;
        }

        int tempN = n;
        for (int i = 1; i <= 8 - depth; i++) {
            int nextDepth = depth + i;
            dfs(nextDepth, num + tempN);
            dfs(nextDepth, num - tempN);
            dfs(nextDepth, num / tempN);
            dfs(nextDepth, num * tempN);

            tempN = tempN * 10 + n;
        }
    }
}

public class Test106 {

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int result = new Solution().solution(N, number);
        System.out.println(result);
    }
}