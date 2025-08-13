package baekjoon.backtracking;

import java.util.*;
import java.io.*;

public class Pro1182 {

    static int N, S;
    static int cnt;

    static int[] nList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);

        nList = new int[N];
        String[] row = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nList[i] = Integer.parseInt(row[i]);
        }

        cnt = 0;

        backtracking(0, 0, 0);

        System.out.println(cnt);
        br.close();
    }

    private static void backtracking(int start, int sum, int depth) {
        if (sum == S && depth > 0) {
            cnt++;
        }

        for (int i = start; i < N; i++) {
            backtracking(i + 1, sum + nList[i], depth + 1);
        }
    }
}
