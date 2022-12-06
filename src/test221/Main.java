package test221;
// PQ/백준/골드2/1655 가운데를 말해요

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // 우선순위 큐
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (maxPQ.size() == minPQ.size()) {
                maxPQ.offer(num);
            } else {
                minPQ.offer(num);
            }

            if (!minPQ.isEmpty()) {
                if (maxPQ.peek() > minPQ.peek()) {
                    int larger = maxPQ.poll();
                    int smaller = minPQ.poll();
                    maxPQ.offer(smaller);
                    minPQ.offer(larger);
                }
            }

            sb.append(maxPQ.peek()).append(lineSeparator());
        }

        System.out.println(sb);
    }
}