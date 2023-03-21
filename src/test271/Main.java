package test271;
// 트리/백준/골드2/2250 트리의 높이와 너비

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static Node[] tree;
    private static int rootNode;
    private static Map<Integer, XPos> map;
    private static int x = 1;

    public static void main(String[] args) throws IOException {
        init();
        setXPos(tree[rootNode], 1);
        int y = 1;
        int maxY = 0;
        int maxWidth = 0;
        while (map.containsKey(y)) {
            XPos xPos = map.get(y);
            int width = xPos.max - xPos.min + 1;
            if (width > maxWidth) {
                maxY = y;
                maxWidth = width;
            }
            y++;
        }
        System.out.println(maxY + " " + maxWidth);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new Node();
        }
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            tree[n].l = l;
            tree[n].r = r;
            if (l != -1) {
                tree[l].p = n;
            }
            if (r != -1) {
                tree[r].p = n;
            }
        }
        rootNode = 0;
        for (int i = 1; i <= N; i++) {
            if (tree[i].p == -1) {
                rootNode = i;
            }
        }
        br.close();
    }

    private static void setXPos(Node curNode, int y) {
        if (curNode.l != -1) {
            setXPos(tree[curNode.l], y + 1);
        }
        map.putIfAbsent(y, new XPos());
        XPos xPos = map.get(y);
        xPos.min = Math.min(x, xPos.min);
        xPos.max = Math.max(x, xPos.max);
        x++;
        if (curNode.r != -1) {
            setXPos(tree[curNode.r], y + 1);
        }
    }
}

class Node {

    public int p = -1;
    public int l = -1;
    public int r = -1;
}

class XPos {

    public int min = Integer.MAX_VALUE;
    public int max = 0;
}