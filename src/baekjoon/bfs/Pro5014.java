package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro5014 {

    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]); // 총 높이
        S = Integer.parseInt(input[1]); // 현재 위치
        G = Integer.parseInt(input[2]); // 가고자 하는 위치
        U = Integer.parseInt(input[3]); // 위로 u 층 이동
        D = Integer.parseInt(input[4]); // 아래로 d 층 이동

        visited = new boolean[F + 1];
        int solution = bfs(S);

        System.out.println(solution != -1 ? solution : "use the stairs");

        br.close();
     }

    private static int bfs(int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});

        visited[start] = true;


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int level = poll[1];

            if (current == G) {
                return level;
            }

            int[] nextList = {
                    current + U,
                    current - D
            };

            for (int next : nextList) {
                if (next > 0 && next <= F && !visited[next]){
                    queue.offer(new int[]{next, level + 1});
                    visited[next] = true;
                }
            }

        }

        return -1;
    }
}
