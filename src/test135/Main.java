package test135;
// 백준/골드5/11000 강의실 배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Class> classPQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            classPQ.offer(new Class(start, end));
        }

        PriorityQueue<Integer> roomPQ = new PriorityQueue<>();
        roomPQ.offer(0);
        int answer = 1;
        while (!classPQ.isEmpty()) {
            Class c = classPQ.poll();
            if (roomPQ.peek() <= c.start) {
                roomPQ.poll();
                roomPQ.offer(c.end);
            } else {
                answer++;
                roomPQ.offer(c.end);
            }
        }

        System.out.println(answer);
    }
}

class Class implements Comparable<Class> {

    public int start;
    public int end;

    public Class(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Class c) {
        return this.start - c.start;
    }
}