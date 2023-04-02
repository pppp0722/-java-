package test282;
// 백트래킹/백준/골드5/7682 틱택토

import static java.lang.System.lineSeparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        String[] board = new String[9];
        Arrays.fill(board, ".");
        backtrack(0, board, true);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();

            if("end".equals(line)) {
                break;
            }

            if(set.contains(line)) {
                sb.append("valid");
            } else {
                sb.append("invalid");
            }
            sb.append(lineSeparator());
        }

        System.out.print(sb);
    }

    private static void backtrack(int depth, String[] board, boolean xTurn) {
        if (depth == 9 || isEnd(board)) {
            set.add(String.join("", board));
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i] == ".") {
                if (xTurn) {
                    board[i] = "X";
                } else {
                    board[i] = "O";
                }
                backtrack(depth + 1, board, !xTurn);
                board[i] = ".";
            }
        }
    }

    private static boolean isEnd(String[] board) {
        for (int i = 0; i < 3; i++) {
            String h = board[3 * i] + board[3 * i + 1] + board[3 * i + 2];
            if ("XXX".equals(h) || "OOO".equals(h)) {
                return true;
            }
            String v = board[i] + board[i + 3] + board[i + 6];
            if ("XXX".equals(v) || "OOO".equals(v)) {
                return true;
            }
        }
        String rd = board[0] + board[4] + board[8];
        if ("XXX".equals(rd) || "OOO".equals(rd)) {
            return true;
        }
        String ld = board[2] + board[4] + board[6];
        if ("XXX".equals(ld) || "OOO".equals(ld)) {
            return true;
        }
        return false;
    }
}