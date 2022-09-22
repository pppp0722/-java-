package test191;
// 백준/골드2/1202 보석 도둑

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            items[i] = new Item(m, v);
        }

        Bag[] bags = new Bag[k];
        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(br.readLine());
            bags[i] = new Bag(c);
        }

        Arrays.sort(items);
        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && items[j].m <= bags[i].c) {
                pq.offer(items[j++].v);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}

class Item implements Comparable<Item> {

    public int m;
    public int v;

    public Item(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Item o) {
        if (this.m == o.m) {
            return o.v - this.v;
        } else {
            return this.m - o.m;
        }
    }
}

class Bag implements Comparable<Bag> {

    public int c;

    public Bag(int c) {
        this.c = c;
    }

    @Override
    public int compareTo(Bag o) {
        return this.c - o.c;
    }
}