package test080;

// 프로그래머스/Level2/양궁대회
public class Test80 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] result = solution.solution(n, info);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}

class Solution {

    static int maxDepth; // 최대 깊이 (n)
    static int[] aInfo; // 어피치가 과녁 맞춘 정보
    static int[] maxLInfo; // 점수 차이가 최대일때 라이언 과녁 맞춘 정보 (계속 갱신)
    static int maxScoreDiff = 0; // 최대 점수 차이 (계속 갱신)

    public int[] solution(int n, int[] info) {
        maxDepth = n; // 전역 변수 maxDepth 초기화
        aInfo = info; // 전역 변수 aInfo 초기화
        int[] initLInfo = new int[11]; // DFS 돌릴 라이언 과녁 맞춘 정보 초기화
        dfs(0, initLInfo, -1); // DFS 시작
        return maxScoreDiff > 0 ? maxLInfo : new int[]{-1}; // 라이언이 이기면 maxLInfo, 지면 {-1} 반환
    }

    public static void dfs(int depth, int[] lInfo, int idx) {
        // 마지막 depth 인 경우
        if (depth == maxDepth) {
            // for 문을 돌면서 라이언과 어피치의 점수의 차이를 계산 (같은 과녁에 동일한 횟수면 어피치 점수)
            int lScore = 0;
            int aScore = 0;
            for (int i = 0; i < 11; i++) {
                if (lInfo[i] > aInfo[i]) {
                    lScore += 10 - i;
                } else if (aInfo[i] != 0) {
                    aScore += 10 - i;
                }
            }
            int scoreDiff = lScore - aScore;
            // 계산한 scoreDiff 가 maxScoreDiff 보다 큰 경우 maxLInfo, maxScoreDiff 교체
            // 같은 경우는 가장 낮은 점수부터 많이 맞춘 경우만 교체
            if (scoreDiff > maxScoreDiff) {
                maxScoreDiff = scoreDiff;
                maxLInfo = lInfo;
            } else if (maxScoreDiff > 0 && scoreDiff == maxScoreDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (lInfo[i] > maxLInfo[i]) {
                        maxScoreDiff = scoreDiff;
                        maxLInfo = lInfo;
                    } else if (maxLInfo[i] > lInfo[i]) {
                        return;
                    }
                }
            }
            return;
        }

        for (int i = idx + 1; i < 11; i++) {
            // 새로운 배열 생성하고 깊은 복사
            int[] nextLInfo = new int[11];
            for (int j = 0; j < 11; j++) {
                nextLInfo[j] = lInfo[j];
            }

            // 마지막 인덱스인데 남았으면 다 쏜걸로 마지막 dfs
            // 라이언이 점수 획득하려면 어피치 맞춘 횟수 + 1 이면 됨
            if (i == 10) {
                nextLInfo[i] += maxDepth - depth;
                dfs(maxDepth, nextLInfo, i);
            } else if (maxDepth - depth > aInfo[i]) {
                nextLInfo[i] += aInfo[i] + 1;
                dfs(depth + aInfo[i] + 1, nextLInfo, i);
            }
        }
    }
}