package test072;

import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스/Level2/다리를 지나는 트럭
public class Test72 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = solution.solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> leftoverTrucks = new LinkedList<>();

        for(int truckWeight : truck_weights) {
            leftoverTrucks.add(truckWeight);
        }

        Queue<Integer> bridge = new LinkedList<>();
        int answer = 0;
        int totalWeight = 0;
        while(true) {
            if(leftoverTrucks.isEmpty()) break;

            if(bridge.size() == bridge_length) {
                totalWeight -= bridge.poll();
            }

            if(totalWeight + leftoverTrucks.peek() <= weight) {
                int newTruckWeight = leftoverTrucks.poll();
                bridge.add(newTruckWeight);
                totalWeight += newTruckWeight;
            } else {
                bridge.add(0);
            }

            answer++;
        }

        return answer + bridge_length;
    }
}