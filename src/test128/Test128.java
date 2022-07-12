package test128;
// 프로그래머스/Level3/불량 사용자

import java.util.HashSet;

class Solution {

    String[] userIds;
    String[] bannedIds;
    boolean[] visited;
    HashSet<HashSet<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        visited = new boolean[userIds.length];

        dfs(new HashSet<>(), 0);

        return result.size();
    }

    void dfs(HashSet<String> set, int depth) {
        if (depth == bannedIds.length) {
            result.add(set);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (set.contains(userIds[i])) {
                continue;
            }

            if (check(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }

    boolean check(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        boolean match = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                match = false;
                break;
            }
        }

        return match;
    }
}

public class Test128 {

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        int answer = new Solution().solution(user_id, banned_id);
        System.out.println(answer);
    }
}