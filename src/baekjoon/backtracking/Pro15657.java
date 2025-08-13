package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro15657 {

    static int N, M;

    static List<Integer> nList;
    static List<Integer> result;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] row1 = br.readLine().split(" ");
        String[] row2 = br.readLine().split(" ");

        N = Integer.parseInt(row1[0]);
        M = Integer.parseInt(row1[1]);

        result = new ArrayList<>();
        nList = new ArrayList<>();


        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            nList.add(Integer.parseInt(row2[i]));
        }

        Collections.sort(nList, (n1, n2) -> {
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            } else {
                return 0;
            }
        });

        backtracking(0, 0);

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

        for (int i = start; i < N; i++) {
            result.add(nList.get(i));

            backtracking(i, depth + 1);

            result.remove(result.size() - 1);
        }
    }
}
