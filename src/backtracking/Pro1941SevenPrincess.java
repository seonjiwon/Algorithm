package backtracking;

import java.io.*;
import java.util.*;

public class Pro1941SevenPrincess {

    static int N = 5;

    static char[][] map;
    static List<int[]> selected;

    static int result;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[N][N];
        selected = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        result = 0;
        backtracking(0, 0, 0, 0);
        System.out.println(result);

        br.close();
    }

    private static void backtracking(int start, int depth, int sCnt, int yCnt) {
        if (depth == 7) {
            if (sCnt >= 4 && isConnected()) {
                result++;
            }
            return;
        }

        for (int pos = start; pos < 25; pos++) {
            int i = pos / 5;
            int j = pos % 5;

            // 현재 위치 선택
            selected.add(new int[]{i, j});

            if (map[i][j] == 'S') {
                backtracking(pos + 1, depth + 1, sCnt + 1, yCnt);
            } else {
                backtracking(pos + 1, depth + 1, sCnt, yCnt + 1);
            }

            selected.remove(selected.size() - 1);
        }
    }

    private static boolean isConnected() {
        boolean[][] tempVisited = new boolean[N][N];

        for (int[] pos : selected) {
            tempVisited[pos[0]][pos[1]] = true;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] bfsVisited = new boolean[N][N];

        int[] start = selected.get(0);
        queue.offer(start);

        bfsVisited[start[0]][start[1]] = true;
        int connectedCount = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 및 방문 체크
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (tempVisited[ny][nx] && !bfsVisited[ny][nx]) {
                        bfsVisited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        connectedCount++;
                    }
                }
            }
        }

        // 선택된 7명이 모두 연결되어 있는지 확인
        return connectedCount == 7;
    }
}
