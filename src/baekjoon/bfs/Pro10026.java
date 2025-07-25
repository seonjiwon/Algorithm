package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro10026 {

    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        visited = new boolean[N][N];
        int normalCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    normalCnt++;
                }
            }
        }

        visited = new boolean[N][N];
        int disabledCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    disabledCnt++;
                }
            }
        }

        System.out.println(normalCnt + " " + disabledCnt);
        br.close();
    }

    private static void bfs(int startX, int startY, boolean isColorBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        char startColor = map[startX][startY];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (isSameColor(startColor, map[nx][ny], isColorBlind)) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private static boolean isSameColor(char a, char b, boolean isColorBlind) {
        if (!isColorBlind) {
            return a == b;
        }

        if (a == b) return true;
        if ((a == 'R' || a == 'G') && (b == 'R' || b == 'G')) return true;
        return false;
    }
}