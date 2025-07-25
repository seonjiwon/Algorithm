package baekjoon.bfs;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Pro2583 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int M, N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        map = new int[M][N];
        visited = new boolean[M][N];


        while (K-- > 0) {
            String[] coordinates = br.readLine().split(" ");
            int x1 = Integer.parseInt(coordinates[0]),
                    y1 = M - Integer.parseInt(coordinates[1]),
                    x2 = Integer.parseInt(coordinates[2]),
                    y2 = M - Integer.parseInt(coordinates[3]);

            for (int i = y2; i < y1; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = 1;
                }
            }
        }


        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    cnt++;
                    int size = bfs(j, i);
                    list.add(size);
                }
            }


        }

        System.out.println(cnt);
        list.stream()
                .sorted()
                .forEach(n -> System.out.print(n + " "));
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        int size = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1], y = current[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[ny][nx] == 0 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        size++;
                    }
                }
            }
        }
        return size;
    }
}
