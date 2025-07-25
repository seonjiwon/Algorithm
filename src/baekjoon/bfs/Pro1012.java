package baekjoon.bfs;

import java.beans.Visibility;
import java.io.*;
import java.util.*;

public class Pro1012 {

    static int M, N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String[] line = br.readLine().split(" ");
            M = Integer.parseInt(line[0]);
            N = Integer.parseInt(line[1]);
            int K = Integer.parseInt(line[2]);

            map = new int[M][N];
            visited = new boolean[M][N];

            while (K-- > 0) {
                String[] coordinates = br.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]), y = Integer.parseInt(coordinates[1]);
                map[x][y] = 1;
            }

            int cnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }

        br.close();
     }

    private static void bfs(int startX, int startY){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});

        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] locations = queue.poll();
            int x = locations[0], y = locations[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
