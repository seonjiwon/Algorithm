package z_resolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String row = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = row.charAt(j);
                }
            }

            int solution = solution();
            if (solution == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(solution);
            }
        }

        br.close();
    }

    private static int solution() {
        Queue<int[]> fQueue = new LinkedList<>();
        Queue<int[]> sQueue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == '*') {
                    fQueue.offer(new int[]{i, j});
                } else if (map[i][j] == '@') {
                    visited[i][j] = true;
                    sQueue.offer(new int[]{i, j, 0});
                }
            }
        }

        while (!sQueue.isEmpty()) {
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
                int[] sg = sQueue.poll();
                int y = sg[0];
                int x = sg[1];
                int time = sg[2];

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j], ny = y + dy[j];

                    if (nx < 0 || nx >= w || ny < 0 || ny >= h) {
                        return time + 1;
                    }

                    if (map[ny][nx] == '.' && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        sQueue.offer(new int[]{ny, nx, time + 1});
                    }
                }
            }

        }

        return -1;
    }
}
