package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver1_11403_경로_찾기 {
    static List<Integer>[] link;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        link = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    link[i].add(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                visited = new boolean[N + 1];
                sb.append(solution(i, j));
                if (j < N + 1) {
                    sb.append(" ");
                }
            }
            if (i < N + 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static int solution(int start, int end) {
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Integer v : link[u]) {
                if (v == end) {
                    return 1;
                }

                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return result;
    }
}
