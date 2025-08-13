package baekjoon.recursive;

import java.io.*;
import java.util.*;

public class Pro1780 {

    static int[][] map;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[3];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

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
                if (target != map[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            result[target + 1] += 1;
        } else {
            int nextN = n / 3;
            recursive(startX, startY, nextN);
            recursive(startX + nextN, startY, nextN);
            recursive(startX + nextN * 2, startY, nextN);

            recursive(startX, startY + nextN, nextN);
            recursive(startX + nextN, startY + nextN, nextN);
            recursive(startX + nextN * 2, startY + nextN, nextN);

            recursive(startX, startY + nextN * 2, nextN);
            recursive(startX + nextN, startY + nextN * 2, nextN);
            recursive(startX + nextN * 2, startY + nextN * 2, nextN);
        }
    }
}
