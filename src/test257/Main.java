package test257;
// 그리디/백준/골드2/1826 연료 채우기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<GasStation> pq1 = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        PriorityQueue<GasStation> pq2 = new PriorityQueue<>((o1, o2) -> o2.w - o1.w);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq1.offer(new GasStation(d, w));
        }
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        // 그리디
        int answer = 0;
        int curP = p;
        while (true) {
            if (curP >= l) {
                break;
            }

            while (!pq1.isEmpty()) {
                if (curP < pq1.peek().d) {
                    break;
                }

                pq2.offer(pq1.poll());
            }

            if (pq2.isEmpty()) {
                answer = -1;
                break;
            }

            GasStation gasStation = pq2.poll();
            curP += gasStation.w;
            answer++;
        }

        // 출력
        System.out.println(answer);
    }
}

class GasStation {
    public int d;
    public int w;

    public GasStation(int d, int w) {
        this.d = d;
        this.w = w;
    }
}
