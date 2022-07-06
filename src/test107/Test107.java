package test107;

// 프로그래머스/Level3/입국 심사
class Solution {

    int n;
    int[] times;

    public long solution(int n, int[] times) {
        this.n = n;
        this.times = times;

        long l = 1;
        long r = Long.MAX_VALUE;
        long m;
        while (l <= r) {
            m = l + (r - l) / 2;

            if (isPossible(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    boolean isPossible(long limit) {
        long num = 0;
        for (int time : times) {
            num += limit / time;
            if (num >= n) {
                return true;
            }
        }

        return false;
    }
}

public class Test107 {

    public static void main(String[] args) {
        int n = 3;
        int[] times = {1, 1, 1};
        long result = new Solution().solution(n, times);
        System.out.println(result);
    }
}