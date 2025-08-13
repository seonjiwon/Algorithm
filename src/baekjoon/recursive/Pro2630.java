package baekjoon.recursive;

import java.io.*;
import java.util.*;

public class Pro2630 {

    static int[] result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        result = new int[2];
        recursive(0, 0, N);

        for (int i : result) {
            System.out.println(i);
        }

        br.close();
     }

    private static void recursive(int startX, int startY, int n) {
        int target = map[startY][startX];
        boolean flag = true;

        for (int i = startY; i < startY + n; i++) {
            for (int j = startX; j < startX + n; j++) {
                if (map[i][j] != target) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            result[target] += 1;
        } else {
            int nextN = n / 2;
            recursive(startX, startY, nextN);
            recursive(startX + nextN, startY, nextN);

            recursive(startX, startY + nextN, nextN);
            recursive(startX + nextN, startY + nextN, nextN);
        }
    }
}
