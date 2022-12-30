package test072;
// 큐/프로그래머스/Level2/다리를 지나는 트럭

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> leftoverTrucks = new LinkedList<>();
        for (int truckWeight : truck_weights) {
            leftoverTrucks.add(truckWeight);
        }

        int answer = bridge_length;
        int totalWeight = 0;
        while (!leftoverTrucks.isEmpty()) {
            if (bridge.size() == bridge_length) {
                totalWeight -= bridge.poll();
            }
            int truckWeight = 0;
            if (leftoverTrucks.peek() + totalWeight <= weight) {
                truckWeight = leftoverTrucks.poll();
            }
            bridge.offer(truckWeight);
            totalWeight += truckWeight;
            answer++;
        }

        return answer;
    }
}