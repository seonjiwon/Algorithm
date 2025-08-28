package backtracking;

import java.util.*;
import java.io.*;

public class Pro15651 {

    static int N, M;

    static List<Integer> result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        result = new ArrayList<>();
        sb = new StringBuilder();


        backtracking(0);

        System.out.println(sb);


        br.close();
    }

    private static void backtracking(int depth) {

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

        for (int i = 1; i < N + 1; i++) {
            result.add(i);

            backtracking(depth + 1);

            result.remove(result.size() - 1);
        }

    }
}
