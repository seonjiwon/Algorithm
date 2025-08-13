package baekjoon.recursive;

import java.util.*;
import java.io.*;

public class Pro2448 {
    static char[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        pattern = new char[N][2 * N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                pattern[i][j] = ' ';
            }
        }

        recursive(0, N-1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void recursive(int y, int x, int n) {
        if (n == 3) {
            pattern[y][x] = '*';

            pattern[y + 1][x - 1] = '*';
            pattern[y + 1][x + 1] = '*';

            for (int i = x - 2; i <= x + 2; i++) {
                pattern[y + 2][i] = '*';
            }
            return;
        }

        int nextN = n / 2;

        recursive(y, x, nextN);

        recursive(y + nextN, x - nextN, nextN);

        recursive(y + nextN, x + nextN, nextN);
    }
}
