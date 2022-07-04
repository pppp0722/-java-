package test105;
// 프로그래머스/Level3/다단계 칫솔 판매
import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> money = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            share(seller[i], amount[i] * 100);
        }

        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = money.getOrDefault(enroll[i], 0);
        }

        return result;
    }

    void share(String node, int sales) {
        int nextSales = sales / 10;
        money.put(node, money.getOrDefault(node, 0) + sales - nextSales);

        if (nextSales > 0 && parent.containsKey(node)) {
            share(parent.get(node), nextSales);
        }
    }
}

public class Test105 {

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] result = new Solution().solution(enroll, referral, seller, amount);
        for (int i : result) {
            System.out.println(i);
        }
    }
}