package baekjoon.backtracking;

import java.util.*;
import java.io.*;

public class Pro6603 {
    static int N;

    static boolean[] visited;
    static List<Integer> nList;
    static List<Integer> result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] row = br.readLine().split(" ");

            if (Integer.parseInt(row[0]) == 0) {
                break;
            }

            N = Integer.parseInt(row[0]);

            nList = new ArrayList<>();
            result = new ArrayList<>();
            visited = new boolean[N];

            for (int i = 1; i < N + 1; i++) {
                nList.add(Integer.parseInt(row[i]));
            }

            sb = new StringBuilder();

            backtracking(0, 0);

            System.out.println(sb);
        }

        br.close();
    }

    private static void backtracking(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));
                if (i < result.size() - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(nList.get(i));

                backtracking(i + 1, depth + 1);

                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
