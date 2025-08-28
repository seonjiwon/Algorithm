package bfs;

import java.io.*;
import java.util.*;

public class Pro5427 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int w, h;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String[] size = br.readLine().split(" ");
            w = Integer.parseInt(size[0]);
            h = Integer.parseInt(size[1]);

            map = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String row = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = row.charAt(j);
                }
            }

            int solution = bfs();

            System.out.println(solution != -1 ? solution : "IMPOSSIBLE");
        }

        br.close();
     }

    private static int bfs(){
        Queue<int[]> sQueue = new LinkedList<>();
        Queue<int[]> fQueue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '*') {
                    fQueue.offer(new int[]{i, j});
                }
                if (map[i][j] == '@') {
                    sQueue.offer(new int[]{i, j, 0});
                    map[i][j] = '.';
                    visited[i][j] = true;
                }
            }
        }

        while (!sQueue.isEmpty()) {
            // 불 먼저 이동
            int fSize = fQueue.size();
            for (int i = 0; i < fSize; i++) {
                int[] fire = fQueue.poll();
                int y = fire[0];
                int x = fire[1];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j], ny = y + dy[j];

                    if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                        if (map[ny][nx] == '.') {
                            map[ny][nx] = '*';
                            fQueue.offer(new int[]{ny, nx});
                        }
                    }
                }

            }

            // 상근이 이동
            int sSize = sQueue.size();
            for (int i = 0; i < sSize; i++) {
                int[] sanggeun = sQueue.poll();
                int y = sanggeun[0];
                int x = sanggeun[1];
                int time = sanggeun[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j], ny = y + dy[j];

                    if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                        return time + 1;
                    }

                    if (map[ny][nx] == '.' && !visited[ny][nx]) {
                        sQueue.offer(new int[]{ny, nx, time + 1});
                        visited[ny][nx] = true;
                    }
                }
            }
        }




        return -1;
    }
}
