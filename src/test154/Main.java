package test154;
// 다익/백준/골드3/1238 파티

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int x;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMaxTime());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, time));
        }
        br.close();
    }

    private static int findMaxTime() {
        int maxTime;
        int[] goTimes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            goTimes[i] = getTimes(i)[x];
        }
        int[] comeTimes = getTimes(x);
        maxTime = getMax(goTimes, comeTimes);
        return maxTime;
    }

    private static int[] getTimes(int startVertex) {
        int[] times = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(times, Integer.MAX_VALUE);
        times[startVertex] = 0;
        pq.offer(new Node(startVertex, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int vertex = node.getVertex();
            int time = node.getTime();
            if (time < times[vertex]) {
                continue;
            }
            for (Node nextNode : graph.get(vertex)) {
                int nextVertex = nextNode.getVertex();
                int nextTime = time + nextNode.getTime();
                if (nextTime < times[nextVertex]) {
                    times[nextVertex] = nextTime;
                    pq.offer(new Node(nextVertex, nextTime));
                }
            }
        }
        return times;
    }

    private static int getMax(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(arr1[i] + arr2[i], max);
        }
        return max;
    }
}

class Node implements Comparable<Node> {

    private final int vertex;
    private final int time;

    public Node(int vertex, int time) {
        this.vertex = vertex;
        this.time = time;
    }

    public int getVertex() {
        return vertex;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Node o) {
        return time - o.time;
    }
}