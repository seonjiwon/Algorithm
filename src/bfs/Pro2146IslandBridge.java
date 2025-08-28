package bfs;

import java.io.*;
import java.util.*;

public class Pro2146IslandBridge {

    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 1단계: 각 섬에 고유 번호 부여
        int islandNum = 2; // 1 대신 2부터 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) { // 아직 번호가 안 매겨진 육지
                    markIsland(i, j, islandNum++);
                }
            }
        }

        // 2단계: 각 섬에서 다른 섬까지 최단 다리 길이 찾기
        int minBridge = Integer.MAX_VALUE;
        for (int island = 2; island < islandNum; island++) {
            int bridgeLength = findShortestBridge(island);
            if (bridgeLength != -1) {
                minBridge = Math.min(minBridge, bridgeLength);
            }
        }

        System.out.println(minBridge);
        br.close();
    }

    // 연결된 육지를 모두 같은 섬 번호로 표시
    private static void markIsland(int startY, int startX, int islandNum) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        map[startY][startX] = islandNum;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0], x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (map[ny][nx] == 1) { // 아직 번호가 안 매겨진 육지
                        map[ny][nx] = islandNum;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    // 특정 섬에서 다른 섬까지의 최단 다리 길이 찾기
    private static int findShortestBridge(int islandNum) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[N][N];

        // 거리 배열 초기화 (-1: 미방문)
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        // 해당 섬의 모든 위치를 시작점으로 설정 (다중 시작점 BFS)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandNum) {
                    queue.offer(new int[]{i, j});
                    dist[i][j] = 0; // 시작 섬은 거리 0
                }
            }
        }

        // BFS로 최단 거리 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0], x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && dist[ny][nx] == -1) {
                    if (map[ny][nx] == 0) { // 바다인 경우
                        dist[ny][nx] = dist[y][x] + 1;
                        queue.offer(new int[]{ny, nx});
                    } else if (map[ny][nx] != islandNum) { // 다른 섬에 도달
                        return dist[y][x]; // 다리 길이 반환
                    }
                }
            }
        }

        return -1; // 다른 섬에 도달할 수 없음
    }
}