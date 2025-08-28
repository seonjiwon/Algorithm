package recursive;

import java.util.*;
import java.io.*;

public class Pro1992 {

    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        sb = new StringBuilder();
        recursive(0, 0, N);

        System.out.println(sb);

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
            sb.append(target);
            return;
        } else {
            sb.append("(");
            int nextN = n / 2;
            recursive(startX, startY, nextN);
            recursive(startX + nextN, startY, nextN);

            recursive(startX, startY + nextN, nextN);
            recursive(startX + nextN, startY + nextN, nextN);
        }

        sb.append(")");
    }
}
