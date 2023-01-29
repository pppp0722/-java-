package test132;
// 해시테이블/프로그래머스/Level4/호텔 방 배정

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<Long, Long> map;

    public long[] solution(long k, long[] room_number) {
        map = new HashMap<>();
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findRoom(room_number[i]);
        }
        return answer;
    }

    private long findRoom(long want) {
        if (!map.containsKey(want)) {
            map.put(want, findNearestRoom(want + 1));
            return want;
        }
        long empty = findRoom(map.get(want));
        map.put(want, empty);
        return empty;
    }

    private long findNearestRoom(long room) {
        if (map.containsKey(room)) {
            return findNearestRoom(map.get(room));
        } else {
            return room;
        }
    }
}
