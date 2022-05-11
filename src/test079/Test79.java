package test079;

// 프로그래머스/Level2/주차 요금 계산

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test79 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
            "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] result = solution.solution(fees, records);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class Solution {

    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<String> carNumPQ = new PriorityQueue<>();
        Map<String, Integer> inMinuteMap = new HashMap();
        Map<String, Integer> totalMinuteMap = new HashMap();

        for (String record : records) {
            String[] split = record.split(" ");
            String[] time = split[0].split(":");
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String carNum = split[1];
            String type = split[2];
            if (type.equals("IN")) {
                if (!carNumPQ.contains(carNum)) {
                    carNumPQ.add(carNum);
                }
                inMinuteMap.put(carNum, minute);
            } else {
                int minuteDiff = minute - inMinuteMap.get(carNum);
                if (totalMinuteMap.containsKey(carNum)) {
                    totalMinuteMap.replace(carNum, totalMinuteMap.get(carNum) + minuteDiff);
                } else {
                    totalMinuteMap.put(carNum, minuteDiff);
                }
                inMinuteMap.remove(carNum);
            }
        }

        for (String carNum : inMinuteMap.keySet()) {
            int minuteDiff = (23 * 60 + 59) - inMinuteMap.get(carNum);
            if (totalMinuteMap.containsKey(carNum)) {
                totalMinuteMap.replace(carNum, totalMinuteMap.get(carNum) + minuteDiff);
            } else {
                totalMinuteMap.put(carNum, minuteDiff);
            }
        }

        while (!carNumPQ.isEmpty()) {
            String carNum = carNumPQ.remove();
            int minute = totalMinuteMap.get(carNum);
            int fee = fees[1];
            if(minute > fees[0]) {
                fee += Math.ceil((double) (minute - fees[0]) / fees[2]) * fees[3];
            }
            answer.add(fee);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}