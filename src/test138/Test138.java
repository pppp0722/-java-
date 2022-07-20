package test138;
// 프로그래머스/Level2/괄호 변환

class Solution {

    public String solution(String p) {
        return dp(p);
    }

    String dp(String p) {
        if (p.equals("")) {
            return p;
        }

        String u = "";
        String v = "";
        int num1 = 0;
        int num2 = 0;
        int idx = 0;
        boolean illegal = false;

        while (idx < p.length()) {
            char c = p.charAt(idx);

            if (c == '(') {
                num1++;
            } else {
                if (num1 == 0) {
                    illegal = true;
                }
                num2++;
            }

            u += c;
            idx++;

            if (num1 != 0 && num1 == num2) {
                break;
            }
        }

        while (idx < p.length()) {
            v += p.charAt(idx++);
        }

        if (illegal) {
            String fixed = "(" + dp(v) + ")";
            for (int i = 1; i < u.length() - 1; i++) {
                char c = u.charAt(i);
                if (c == '(') {
                    fixed += ")";
                } else {
                    fixed += "(";
                }
            }

            return fixed;
        } else {
            return u + dp(v);
        }
    }
}

public class Test138 {

    public static void main(String[] args) {
        String p = "()))((()";
        String answer = new Solution().solution(p);
        System.out.println(answer);
    }
}
