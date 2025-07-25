package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro4179BfsWithSize {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int r, c;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        r = Integer.parseInt(size[0]);
        c = Integer.parseInt(size[1]);

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int result = bfs();

        System.out.println(result != -1 ? result : "IMPOSSIBLE");

        br.close();
    }

    private static int bfs() {
        Queue<int[]> jQueue = new LinkedList<>();
        Queue<int[]> fQueue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'J') {
                    jQueue.offer(new int[]{i, j, 0});
                    map[i][j] = '.';
                } else if (map[i][j] == 'F') {
                    fQueue.offer(new int[]{i, j});
                }
            }
        }


        while (!jQueue.isEmpty()) {

            // 불 먼저 이동
            int fSize = fQueue.size();
            for (int f = 0; f < fSize; f++) {
                int[] fire = fQueue.poll();
                int fx = fire[0], fy = fire[1];

                for (int i = 0; i < 4; i++) {
                    int fnx = fx + dx[i];
                    int fny = fy + dy[i];

                    if (fnx >= 0 && fnx < r && fny >= 0 && fny < c) {
                        if (map[fnx][fny] == '.') {
                            map[fnx][fny] = 'F';
                            fQueue.offer(new int[]{fnx, fny});
                        }
                    }
                }
            }


            // 지훈이 이동
            int jSize = jQueue.size();
            for (int i = 0; i < jSize; i++) {
                int[] jihun = jQueue.poll();
                int jx = jihun[0], jy = jihun[1], seconds = jihun[2];

                for (int j = 0; j < 4; j++) {
                    int jnx = jx + dx[j];
                    int jny = jy + dy[j];


                    if (jnx < 0 || jnx >= r || jny < 0 || jny >= c) {
                        return seconds + 1;
                    }

                    if (map[jnx][jny] == '.') {
                        map[jnx][jny] = 'J';
                        jQueue.offer(new int[]{jnx, jny, seconds + 1});
                    }
                }
            }



        }


        return -1;
    }
}
