package bfs;

import java.io.*;
import java.util.*;

public class Pro2563 {

    static int N, M;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        // 0 -> 녹기전의 상태, 1 -> 녹은 후의 상태
        map = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[0][i][j] = Integer.parseInt(row[j]);
            }
        }

        int result = 0;
        int year = 0;
        while (true) {
            // 빙산의 블록세는 bfs
            int blockCnt = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[0][i][j] != 0 && !visited[i][j]) {
                        blockCnt++;
                        bfs(i, j);
                    }
                }
            }

            // 블록이 2개 이면
            if (blockCnt >= 2){
                result = year;
                break;
            }
            // 전부 녹아 사라진 상태면
            if (blockCnt == 0) {
                break;
            }

            // 빙산 녹이기
            int meltCnt;
            for (int i = 0; i < N; i++) {
                meltCnt = 0;
                for (int j = 0; j < M; j++) {
                    if (map[0][i][j] != 0) {
                        meltCnt = meltingIceBerg(i, j);
                    }
                    map[1][i][j] = Math.max(map[0][i][j] - meltCnt, 0);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    map[0][i][j] = map[1][i][j];
                }
//                System.out.println(Arrays.toString(map[0][i]));
            }

//            System.out.println();
            year++;
        }

        System.out.println(result);

        br.close();
     }

    private static int meltingIceBerg(int startY, int startX) {
        int meltCnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i], ny = startY + dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if (map[0][ny][nx] == 0) {
                    meltCnt++;
                }
            }
        }

        return meltCnt;
    }

    private static void bfs(int startY, int startX){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0], x = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[ny][nx] && map[0][ny][nx] != 0) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }

        }
    }
}
