package bfs;

import java.io.*;
import java.util.*;

public class Pro2667 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int cnt = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    cnt++;
                    result.add(bfs(j, i));
                }
            }
        }

        System.out.println(cnt);
        result.stream()
                .sorted()
                .forEach(System.out::println);
        br.close();
     }

    private static int bfs(int startX, int startY) {
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});

        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1], y = current[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (map[ny][nx] == '1' && !visited[ny][nx]) {
                        queue.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        size++;
                    }
                }

            }
        }


        return size;
    }
}
