package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro7562 {

    static int I;
    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            I = Integer.parseInt(br.readLine());
            map = new boolean[I][I];
            String[] current = br.readLine().split(" ");
            String[] target = br.readLine().split(" ");

            int x = Integer.parseInt(current[0]), y = Integer.parseInt(current[1]);
            int tx = Integer.parseInt(target[0]), ty = Integer.parseInt(target[1]);

            int solution = bfs(x, y, tx, ty);
            System.out.println(solution);
        }

        br.close();
     }

    private static int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], cnt = current[2];

            if (x == targetX && y == targetY) {
                return cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < I && ny >= 0 && ny < I) {
                    if (!map[nx][ny]){
                        map[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, cnt+1});
                    }
                }

            }

        }

        return -1;
    }
}
