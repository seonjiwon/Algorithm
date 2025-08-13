package baekjoon.recursive;

import java.util.*;
import java.io.*;

public class Pro2447 {

    static char[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        pattern = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pattern[i][j] = ' ';
            }
        }

        recursive(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);


        br.close();
     }

    private static void recursive(int y, int x, int n){
        if (n == 1) {
            pattern[y][x] = '*';
            return;
        }

        int nextN = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                recursive(y + i * nextN, x + j * nextN, nextN);
            }
        }

    }
}
