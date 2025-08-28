package bfs;

import java.io.*;
import java.util.*;

public class Pro6593 {

    static int L, R, C;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static char[][][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = br.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            int startZ = 0, startY = 0, startX = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String row = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = row.charAt(k);
                        map[i][j][k] = c;
                        if (c == 'S') {
                            startZ = i;
                            startY = j;
                            startX = k;
                        }
                    }
                }
                br.readLine();
            }

            int solution = bfs(startX, startY, startZ);
            System.out.println(solution != -1 ? "Escaped in " + solution + " minute(s)." : "Trapped!");
        }

        br.close();
    }

    private static int bfs(int startX, int startY, int startZ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startZ, startY, startX, 0});
        visited[startZ][startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0];
            int y = current[1];
            int x = current[2];
            int time = current[3];

            if (map[z][y][x] == 'E') {
                return time;
            }

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i], ny = y + dy[i], nx = x + dx[i];

                if (nz >= 0 && nz < L && ny >= 0 && ny < R && nx >= 0 && nx < C) {
                    if ((map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E') && !visited[nz][ny][nx]) {
                        queue.offer(new int[]{nz, ny, nx, time + 1});
                        visited[nz][ny][nx] = true;
                    }
                }
            }
        }

        return -1;
    }


}
