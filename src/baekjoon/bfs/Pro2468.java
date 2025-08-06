package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro2468 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        List<Integer> list = new ArrayList<>();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int length = Integer.parseInt(row[j]);
                map[i][j] = length;
                list.add(length);
            }
        }

        Set<Integer> set = new HashSet<>(list);
        set.add(0);

        int maxCnt = 0;
        for (Integer minLength : set) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int p = 0; p < N; p++) {
                for (int q = 0; q < N; q++) {
                    if (map[p][q] > minLength && !visited[p][q]) {
                        cnt++;
                        bfs(q, p, minLength);
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);

        br.close();
     }

    private static void bfs(int startX, int startY, int minLength){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[ny][nx] > minLength && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
