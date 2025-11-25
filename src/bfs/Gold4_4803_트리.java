package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_4803_트리 {
    static List<Integer>[] link;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            link = new ArrayList[n + 1];
            visited = new boolean[n + 1];

            for (int i = 1; i < n + 1; i++) {
                link[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
                link[u].add(v);
                link[v].add(u);
            }

            int result = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i]) {
                    if (bfs(i)) {
                        result++;
                    }
                }
            }

            System.out.print("Case " + tc + ": ");
            if (result == 0) {
                System.out.println("No trees.");
            } else if (result == 1) {
                System.out.println("There is one tree.");
            } else {
                System.out.println("A forest of " + result + " trees.");
            }

            tc++;
        }

        br.close();
    }

    private static boolean bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int previous = current[1];

            for (int v : link[u]) {
                if (visited[v] && v != previous) {
                    return false;
                }

                if (!visited[v]) {
                    queue.offer(new int[]{v, u});
                    visited[v] = true;
                }
            }
        }

        return true;
    }
}
