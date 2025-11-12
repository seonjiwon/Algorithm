package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2_5567_결혼식 {
    static List<Integer>[] link;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        link = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }


        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            link[u].add(v);
            link[v].add(u);
        }

        System.out.println(solution());

        br.close();
    }

    private static int solution() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1});
        visited[1] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int depth = current[1];

            for (Integer v : link[u]) {
                if (!visited[v] && depth <= 2) {
                    visited[v] = true;
                    queue.offer(new int[]{v, depth + 1});
                    count++;
                }
            }
        }

        return count;
    }
}
