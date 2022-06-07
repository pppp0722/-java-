package test089;
// 백준/골드4/1939번 중량제한

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sizes = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        ArrayList<ArrayList<Bridge>> bridges = new ArrayList<>();
        for (int i = 0; i <= sizes[0]; i++) {
            bridges.add(new ArrayList<>());
        }

        int maxWeight = 0;
        for (int i = 0; i < sizes[1]; i++) {
            int[] bridge = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            bridges.get(bridge[0]).add(new Bridge(bridge[1], bridge[2]));
            bridges.get(bridge[1]).add(new Bridge(bridge[0], bridge[2]));
            if (bridge[2] > maxWeight) {
                maxWeight = bridge[2];
            }
        }

        int[] way = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int left = 0;
        int right = maxWeight;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(bridges, way, mid, new boolean[sizes[0] + 1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    public static boolean bfs(
        ArrayList<ArrayList<Bridge>> bridges,
        int[] way,
        int weight,
        boolean[] visited
    ) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(way[0]);
        visited[way[0]] = true;

        while (!queue.isEmpty()) {
            int current = queue.remove();

            if (current == way[1]) {
                return true;
            }

            for (Bridge bridge : bridges.get(current)) {
                if (!visited[bridge.getDestination()] && bridge.getWeight() >= weight) {
                    visited[bridge.getDestination()] = true;
                    queue.add(bridge.getDestination());
                }
            }
        }
        return false;
    }
}

class Bridge {

    private final int destination;
    private final int weight;

    public Bridge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}
