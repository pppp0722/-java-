package test270;
// 트리/백준/골드5/15681 트리와 쿼리

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int r;
    private static List<List<Integer>> tree;
    private static int[] queryArr;
    private static int[] numOfNodesArr;

    public static void main(String[] args) throws IOException {
        init();
        findNumOfNodes(r, 0);
        StringBuilder answer = new StringBuilder();
        for (int query : queryArr) {
            answer.append(numOfNodesArr[query]).append(lineSeparator());
        }
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        queryArr = new int[q];
        for (int i = 0; i < q; i++) {
            queryArr[i] = Integer.parseInt(br.readLine());
        }
        numOfNodesArr = new int[n + 1];
        br.close();
    }

    private static int findNumOfNodes(int curNode, int parentNode) {
        int numOfNodes = 1;
        tree.get(curNode).removeIf(e -> e == parentNode);
        for (int childNode : tree.get(curNode)) {
            numOfNodes += findNumOfNodes(childNode, curNode);
        }
        numOfNodesArr[curNode] = numOfNodes;
        return numOfNodes;
    }
}
