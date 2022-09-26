package test192;
// 백준/실버2/1406 에디터

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[] dat = new char[1_000_000];
    private static int[] pre = new int[1_000_000];
    private static int[] nxt = new int[1_000_000];
    private static int unused = 1;

    public static void main(String[] args) throws IOException {
        dat[0] = '-';
        pre[0] = -1;
        nxt[0] = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cursor = 0;
        String init = br.readLine();
        for (int i = 0; i < init.length(); i++) {
            add(cursor++, init.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0].charAt(0)) {
                case 'L':
                    if (pre[cursor] != -1) {
                        cursor = pre[cursor];
                    }
                    break;
                case 'D':
                    if (nxt[cursor] != -1) {
                        cursor = nxt[cursor];
                    }
                    break;
                case 'B':
                    if (pre[cursor] != -1) {
                        remove(cursor);
                        cursor = pre[cursor];
                    }
                    break;
                default:
                    add(cursor, command[1].charAt(0));
                    cursor = nxt[cursor];
                    break;
            }
        }

        System.out.println(search());
    }

    private static String search() {
        StringBuilder sb = new StringBuilder();
        int addr = 0;
        while (nxt[addr] != -1) {
            sb.append(dat[nxt[addr]]);
            addr = nxt[addr];
        }
        return sb.toString();
    }

    private static void add(int addr, char ch) {
        dat[unused] = ch;
        pre[unused] = addr;
        nxt[unused] = nxt[addr];
        if (nxt[addr] != -1) {
            pre[nxt[addr]] = unused;
        }
        nxt[addr] = unused;
        unused++;
    }

    private static void remove(int addr) {
        nxt[pre[addr]] = nxt[addr];
        if (nxt[addr] != -1) {
            pre[nxt[addr]] = pre[addr];
        }
    }
}
