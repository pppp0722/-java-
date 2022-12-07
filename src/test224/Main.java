package test224;
// 그리디/백준/골드2/1781 컵라면

import static java.util.Comparator.comparingInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Homework> homeworks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            homeworks.add(new Homework(deadline, num));
        }

        // 그리디
        Collections.sort(homeworks, comparingInt(o -> o.deadline));
        PriorityQueue<Homework> pq = new PriorityQueue<>(comparingInt(o -> o.num));
        for (Homework homework : homeworks) {
            pq.offer(homework);
            while (pq.size() > homework.deadline) {
                pq.poll();
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll().num;
        }

        System.out.println(answer);
    }
}

class Homework {

    public int deadline;
    public int num;

    public Homework(int deadline, int num) {
        this.deadline = deadline;
        this.num = num;
    }
}