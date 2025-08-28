package bfs;

import java.io.*;
import java.util.*;

public class Pro2206BfsTripleArray {

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
        br.close();
     }

    private static int bfs(){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];
            int distance = current[2];
            int broken = current[3];

            if (x == M - 1 && y == N - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][broken]) {
                        visited[ny][nx][broken] = true;
                        queue.offer(new int[]{ny, nx, distance + 1, broken});
                    } else if (map[ny][nx] == 1) {
                        if (broken == 0 && !visited[ny][nx][1]) {
                            visited[ny][nx][1] = true;
                            queue.offer(new int[]{ny, nx, distance + 1, 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
