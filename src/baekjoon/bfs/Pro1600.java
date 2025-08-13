package baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Pro1600 {

    static int[] monkeyDx = {0, 0, 1, -1};
    static int[] monkeyDy = {1, -1, 0, 0};

    static int[] horseDx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] horseDy = {2, -2, 2, -2, 1, -1, 1, -1};

    static int K;
    static int W, H;

    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        String[] size = br.readLine().split(" ");
        W = Integer.parseInt(size[0]);
        H = Integer.parseInt(size[1]);

        map = new int[H][W];
        visited = new boolean[H][W][K+1];
        for (int i = 0; i < H; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(bfs());
        br.close();
     }

    private static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});

        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0], x = current[1];
            int distance = current[2], horseUsed = current[3];

            if (x == W - 1 && y == H - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + monkeyDx[i], ny = y + monkeyDy[i];
                if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][horseUsed]){
                        visited[ny][nx][horseUsed] = true;
                        queue.offer(new int[]{ny, nx, distance + 1, horseUsed});
                    }
                }
            }

            if (horseUsed < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + horseDx[i], ny = y + horseDy[i];
                    if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                        if (map[ny][nx] == 0 && !visited[ny][nx][horseUsed + 1]) {
                            visited[ny][nx][horseUsed + 1] = true;
                            queue.offer(new int[]{ny, nx, distance + 1, horseUsed + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
