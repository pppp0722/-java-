package test190;
// 백준/골드4/7662 이중 우선순위 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();
            int iCt = 0;
            int dCt = 0;

            for (int j = 0; j < k; j++) {
                String[] line = br.readLine().split(" ");
                char command = line[0].charAt(0);
                int num = Integer.parseInt(line[1]);

                if (command == 'I') {
                    minPQ.offer(num);
                    maxPQ.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    iCt++;
                } else if (iCt > dCt) {
                    int removed = remove(num == -1 ? minPQ : maxPQ, map);
                    map.put(removed, map.get(removed) - 1);
                    dCt++;
                }
            }

            if (iCt == dCt) {
                System.out.println("EMPTY");
            } else {
                minPQ.offer(remove(minPQ, map));
                maxPQ.offer(remove(maxPQ, map));
                System.out.println(maxPQ.poll() + " " + minPQ.poll());
            }
        }
    }

    public static int remove(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        int removed;
        do {
            removed = pq.poll();
        } while (pq.size() > 0 && map.get(removed) == 0);

        return removed;
    }
}
