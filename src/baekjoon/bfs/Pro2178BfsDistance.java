package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro2178BfsDistance {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;
    static int[][] map;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size= br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        int solution = bfs();

        System.out.println(solution);

        br.close();
     }

     private static int bfs(){
         Queue<int[]> queue = new LinkedList<>();
         queue.offer(new int[]{0, 0, 1}); // x, y, 거리
         visited[0][0] = true;

         while (!queue.isEmpty()) {
             int[] current = queue.poll();
             int x = current[0];
             int y = current[1];
             int distance = current[2];

             if (x == n - 1 && y == m - 1) {
                 return distance;
             }

             for (int i = 0; i < 4; i++) {
                 int nx = x + dx[i];
                 int ny = y + dy[i];

                 if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                     if (!visited[nx][ny] && map[nx][ny] == 1){
                         visited[nx][ny] = true;
                         queue.offer(new int[]{nx, ny, distance+1});
                     }
                 }
             }
         }

        return -1;
     }
}
