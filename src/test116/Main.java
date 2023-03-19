package test116;
// 그리디/백준/골드3/2457 공주님의 정원

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int START_DAY = getDay(3, 1);
    private static final int END_DAY = getDay(11, 30);
    private static PriorityQueue<Flower> flowers;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(findMin());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        flowers = new PriorityQueue<>(Comparator.comparingInt(f -> f.startDay));
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            flowers.add(new Flower(getDay(startMonth, startDay), getDay(endMonth, endDay)));
        }
        br.close();
    }

    private static int getDay(int month, int day) {
        int ret = 0;
        for (int i = 1; i < month; i++) {
            ret += DAYS[i];
        }
        return ret + day;
    }

    private static int findMin() {
        int ct = 0;
        int curDay = START_DAY;
        PriorityQueue<Flower> pq = new PriorityQueue<>((f1, f2) -> f2.endDay - f1.endDay);
        while (!flowers.isEmpty()) {
            while (!flowers.isEmpty() && flowers.peek().startDay <= curDay) {
                pq.offer(flowers.poll());
            }
            if (pq.isEmpty()) {
                break;
            }
            Flower nextFlower = pq.poll();
            curDay = nextFlower.endDay;
            ct++;
            if (curDay > END_DAY) {
                break;
            }
        }
        if (curDay <= END_DAY) {
            ct = 0;
        }
        return ct;
    }
}

class Flower {

    public int startDay;
    public int endDay;

    public Flower(int startDay, int endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }
}
