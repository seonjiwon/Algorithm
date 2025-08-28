package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro15664 {

    static int N, M;

    static boolean[] visited;
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
        visited = new boolean[N];

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

        int lastUsed = -1;

        for (int i = start; i < N; i++) {

            if (!visited[i] && nList.get(i) != lastUsed) {
                result.add(nList.get(i));
                visited[i] = true;
                lastUsed = nList.get(i);

                backtracking(i + 1, depth + 1);

                result.remove(result.size() - 1);
                visited[i] = false;
            }


        }
    }
}
