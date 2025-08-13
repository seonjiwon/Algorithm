package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Pro15652 {

    static int N, M;

    static List<Integer> result;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        sb = new StringBuilder();
        result = new ArrayList<>();

        backtracking(1, 0);

        System.out.println(sb);

        br.close();
    }

    private static void backtracking(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
                if (i < result.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            result.add(i);

            backtracking(i, depth + 1);

            result.remove(result.size() - 1);
        }
    }
}
