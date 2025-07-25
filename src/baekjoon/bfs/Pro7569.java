package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro7569 {

    static int N, M, H;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int[][][] map;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        M = Integer.parseInt(size[0]);
        N = Integer.parseInt(size[1]);
        H = Integer.parseInt(size[2]);

        map = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] row = br.readLine().split(" ");
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(row[k]);
                }
            }
        }

        int result = bfs();
        System.out.println(result);

        br.close();
     }

    private static int bfs(){
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 1) {
                        queue.offer(new int[]{j, k, i, 0});
                    }
                }
            }
        }


        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int z = current[2];
            int days = current[3];

            maxDays = Math.max(days, maxDays);

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i], ny = y + dy[i], nz = z + dz[i];


                if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = 1;
                        queue.offer(new int[]{nx, ny, nz, days + 1});
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }

        return maxDays;
    }
}
