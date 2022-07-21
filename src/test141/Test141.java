package test141;
// 프로그래머스/Level4/가사 검색 (효율성 테스트 실패)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {

    Node head = new Node();

    public int[] solution(String[] words, String[] queries) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node node = head;
            for (int j = 0; j < word.length(); j++) {
                String letter = word.substring(j, j + 1);

                if (!node.nextNodes.containsKey(letter)) {
                    node.nextNodes.put(letter, new Node());
                }

                if (j == word.length() - 1) {
                    node.nextNodes.get(letter).setWord(true);
                }

                node = node.nextNodes.get(letter);
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            answer[i] = bfs(queries[i]);
        }

        return answer;
    }

    public int bfs(String query) {
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        int num = 0;
        for (int i = 0; i < query.length(); i++) {
            String letter = query.substring(i, i + 1);
            List<Node> list = new ArrayList<>();
            while (!q.isEmpty()) {
                list.add(q.poll());
            }

            for (Node node : list) {
                if (letter.equals("?")) {
                    for (Node nextNode : node.nextNodes.values()) {
                        q.offer(nextNode);
                    }
                } else {
                    if (node.nextNodes.containsKey(letter)) {
                        q.offer(node.nextNodes.get(letter));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.isWord) {
                num++;
            }
        }

        return num;
    }
}

class Node {

    public boolean isWord = false;
    public Map<String, Node> nextNodes;

    public Node() {
        this.nextNodes = new HashMap<>();
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}

public class Test141 {

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answer = new Solution().solution(words, queries);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}
