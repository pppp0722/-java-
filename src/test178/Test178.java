package test178;
// 프로그래머스/Level1/성격 유형 검사하기

public class Test178 {

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String answer = new Solution().solution(survey, choices);
        System.out.println(answer);
    }
}

class Solution {

    public String solution(String[] survey, int[] choices) {
        int len = survey.length;
        int[] result = new int[4];
        for (int i = 0; i < len; i++) {
            char alphabet = survey[i].charAt(0);
            int choice = choices[i] - 4;
            switch (alphabet) {
                case 'R':
                    result[0] += choice;
                    break;
                case 'T':
                    result[0] -= choice;
                    break;
                case 'C':
                    result[1] += choice;
                    break;
                case 'F':
                    result[1] -= choice;
                    break;
                case 'J':
                    result[2] += choice;
                    break;
                case 'M':
                    result[2] -= choice;
                    break;
                case 'A':
                    result[3] += choice;
                    break;
                case 'N':
                    result[3] -= choice;
                    break;
            }
        }
        String answer = "";
        for (int i = 0; i < 4; i++) {
            int num = result[i];
            switch (i) {
                case 0:
                    if (num > 0) {
                        answer += "T";
                    } else {
                        answer += "R";
                    }
                    break;
                case 1:
                    if (num > 0) {
                        answer += "F";
                    } else {
                        answer += "C";
                    }
                    break;
                case 2:
                    if (num > 0) {
                        answer += "M";
                    } else {
                        answer += "J";
                    }
                    break;
                case 3:
                    if (num > 0) {
                        answer += "N";
                    } else {
                        answer += "A";
                    }
                    break;
            }
        }
        return answer;
    }
}