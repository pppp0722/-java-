package test082;
// 프로그래머스/Level2/소수 찾기

import java.util.ArrayList;
import java.util.List;

public class Test82 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String numbers = "011";
        int answer = solution.solution(numbers);
        System.out.println(answer);
    }
}

class Solution {

    static String numbers;
    static boolean[] visited;
    static List<Integer> checkedNumbers = new ArrayList<>();
    static int answer = 0;

    public int solution(String numbers) {
        this.numbers = numbers;
        visited = new boolean[numbers.length()];
        findPrimeNumber(0);

        return answer;
    }

    public void findPrimeNumber(int currNumber) {
        if (checkedNumbers.contains(currNumber)) {
            return;
        }

        checkedNumbers.add(currNumber);
        if (isPrimeNumber(currNumber)) {
            answer++;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            int nexNumber = Integer.parseInt(String.valueOf(currNumber) + numbers.charAt(i));
            findPrimeNumber(nexNumber);
            visited[i] = false;
        }
    }

    public boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}