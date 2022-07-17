package test132;
// 프로그래머스/Level4/호텔 방 배정

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for (int i = 0; i < room_number.length; i++) {
            answer[i] = getRoom(room_number[i]);
        }

        return answer;
    }

    long getRoom(long want) {
        if (!map.containsKey(want)) {
            map.put(want, want + 1);

            return want;
        }

        long next = map.get(want);
        long empty = getRoom(next);
        map.put(want, empty);

        return empty;
    }
}

public class Test132 {

    public static void main(String[] args) {
        int k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};
        long[] answer = new Solution().solution(k, room_number);
        for (long l : answer) {
            System.out.print(l + " ");
        }
    }
}
