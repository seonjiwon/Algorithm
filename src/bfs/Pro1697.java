package bfs;

import java.io.*;
import java.util.*;

public class Pro1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] locations = br.readLine().split(" ");
        int N = Integer.parseInt(locations[0]);
        int K = Integer.parseInt(locations[1]);

        int solution = bfs(N, K);
        System.out.println(solution);

        br.close();
     }

    private static int bfs(int N, int K) {
        if (N == K) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100_001];

        queue.offer(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentNode = poll[0];
            int level = poll[1];

            int[] nextPosition = {
                    currentNode - 1,
                    currentNode + 1,
                    currentNode * 2
            };

            for (int next : nextPosition) {
                if (next == K) {
                    return level + 1;
                }
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, level + 1});
                }
            }

        }

        return -1;
    }
}
