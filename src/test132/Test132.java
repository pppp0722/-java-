package test132;
// 해시테이블/프로그래머스/Level4/호텔 방 배정

import java.util.HashMap;
import java.util.Map;

class Solution {

    private final Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] assignedRooms = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            assignRoom(assignedRooms, i, room_number[i]);
        }
        return assignedRooms;
    }

    private void assignRoom(long[] assignedRooms, int customerIdx, long want) {
        long assignedRoom = find(want);
        union(assignedRoom, assignedRoom + 1);
        assignedRooms[customerIdx] = assignedRoom;
    }

    private void union(long num1, long num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 != num2) {
            map.put(num1, num2);
        }
    }

    private long find(long num) {
        if (!map.containsKey(num)) {
            return num;
        }
        long nextNum = find(map.get(num));
        map.put(num, nextNum);
        return nextNum;
    }
}
