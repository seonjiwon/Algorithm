package baekjoon.backtracking;

import java.util.*;
import java.io.*;

public class Pro15650 {

    static int N, M;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        result = new ArrayList<>();

        backtracking(1, 0);

        br.close();
    }


    private static void backtracking(int start, int depth) {

        if (depth == M) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            result.add(i);

            backtracking(i + 1, depth + 1);

            result.remove(result.size() - 1);
        }
    }
}
