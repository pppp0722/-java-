package test179;
// 프로그래머스/Level2/두 큐 합 같게 만들기

import java.util.LinkedList;
import java.util.Queue;

public class Test179 {

    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        int answer = new Solution().solution(queue1, queue2);
        System.out.println(answer);
    }
}

class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int max = queue1.length * 4;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long n1 = 0;
        long n2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            n1 += queue1[i];
            n2 += queue2[i];
        }
        int answer = 0;
        while (n1 != n2) {
            if (answer == max) {
                answer = -1;
                break;
            }
            int num;
            if (n1 > n2) {
                num = q1.poll();
                n1 -= num;
                n2 += num;
                q2.offer(num);
            } else {
                num = q2.poll();
                n2 -= num;
                n1 += num;
                q1.offer(num);
            }
            answer++;
        }
        return answer;
    }
}