package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro7576 {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        m = Integer.parseInt(size[0]);
        n = Integer.parseInt(size[1]);

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int result = bfs();
        System.out.println(result);

        br.close();
     }

    private static int bfs(){
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int days = current[2];

            maxDays = Math.max(maxDays, days);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] == 0){
                        map[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny, days + 1});
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
            }
        }

        return maxDays;
    }

}
