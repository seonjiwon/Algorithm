package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_1707_이분_그래프 {
    static List<Integer>[] link;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());

            link = new ArrayList[V + 1];
            color = new int[V + 1];
            for (int i = 0; i < V + 1; i++) {
                link[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
                link[u].add(v);
                link[v].add(u);
            }

            boolean result = true;
            for (int i = 1; i < V + 1; i++) {
                if (color[i] == 0) {
                    result = solution(i);
                }
                if (!result) {
                    break;
                }
            }

            System.out.println(result ? "YES" : "NO");
        }

        br.close();
    }

    private static boolean solution(int start) {
        boolean result = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); // 시작 1, 0
        color[start] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : link[u]) {
                if (color[u] == color[v]) {
                    return false;
                }

                if (color[v] == 0) {
                    color[v] = color[u] * -1;
                    queue.offer(v);
                }
            }
        }

        return result;
    }
}
