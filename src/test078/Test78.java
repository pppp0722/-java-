package test078;

// 프로그래머스/Level2/k진수에서 소수 개수 구하기
public class Test78 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 437674;
        int k = 3;
        int result = solution.solution(n, k);
        System.out.println(result);
    }
}

class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        String kNum = toKnum(n, k);
        String split = "";
        for (int i = 0; i < kNum.length(); i++) {
            if (kNum.charAt(i) != '0') {
                split += kNum.charAt(i);
                continue;
            }

            if(!split.equals("")) {
                if (isPrimeNum(Long.parseLong(split))) {
                    answer++;
                }

                split = "";
            }
        }

        if (!split.equals("")) {
            if (isPrimeNum(Long.parseLong(split))) {
                answer++;
            }
        }

        return answer;
    }

    public String toKnum(int num, int k) {
        String kNum = "";
        while (num > 0) {
            int mod = num % k;
            kNum = mod + kNum;
            num /= k;
        }

        return kNum;
    }

    public boolean isPrimeNum(long num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}