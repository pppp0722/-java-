package test129;
// 프로그래머스/Level3/징검다리 건너기

class Solution {

    int[] stones;
    int k;

    public int solution(int[] stones, int k) {
        this.stones = stones;
        this.k = k;

        int l = 1;
        int r = 300_000_000;
        while (l < r) {
            int m = (l + r) / 2;
            if (isPossible(m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return r - 1;
    }

    boolean isPossible(int num) {
        int ct = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - (num - 1) > 0) {
                ct = 0;
            } else {
                ct++;
            }

            if (ct == k) {
                return false;
            }
        }

        return true;
    }
}

public class Test129 {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int answer = new Solution().solution(stones, k);
        System.out.println(answer);
    }
}