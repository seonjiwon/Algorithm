package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Pro1926BfsMaxExtent {

    // 상하좌우 이동을 위한 방향 배열
    static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 왼쪽, 오른쪽
    static int[] dy = {0, 0, -1, 1};

    static int n, m; // 세로(행), 가로(열)
    static int[][] map; // 그림 정보를 저장할 2차원 배열
    static boolean[][] visited; // 방문 여부를 체크할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: n(세로), m(가로) 입력
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        // 배열 초기화
        map = new int[n][m];
        visited = new boolean[n][m];

        // 그림 정보 입력 (1: 그림 있음, 0: 그림 없음)
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        int pictureCount = 0; // 그림의 개수
        int maxSize = 0; // 가장 큰 그림의 넓이

        // 모든 좌표를 확인하면서 BFS 실행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 그림이 있고(1) 아직 방문하지 않은 곳이면 BFS 시작
                if (map[i][j] == 1 && !visited[i][j]) {
                    pictureCount++; // 새로운 그림 발견
                    int currentSize = bfs(i, j); // BFS로 연결된 그림의 크기 계산
                    maxSize = Math.max(maxSize, currentSize); // 최대 크기 갱신
                }
            }
        }

        // 결과 출력
        System.out.println(pictureCount);
        System.out.println(maxSize);

        br.close();
    }

    static int bfs(int startX, int startY) {
        // BFS에 사용할 큐 생성 (좌표를 저장하기 위해 int 배열 사용)
        Queue<int[]> queue = new LinkedList<>();

        // 시작점을 큐에 추가하고 방문 표시
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int size = 1; // 현재 그림의 크기 (시작점 포함이므로 1부터 시작)

        // 큐가 빌 때까지 반복 (연결된 모든 그림 탐색)
        while (!queue.isEmpty()) {
            // 큐에서 현재 탐색할 좌표를 꺼냄
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // 현재 위치에서 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 새로운 x좌표
                int ny = y + dy[i]; // 새로운 y좌표

                // 새로운 좌표가 유효한 범위 내에 있는지 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 그림이 있고(1) 아직 방문하지 않은 곳이면
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true; // 방문 표시
                        queue.offer(new int[]{nx, ny}); // 큐에 추가하여 다음에 탐색
                        size++; // 그림 크기 증가
                    }
                }
            }
        }

        return size; // 연결된 그림의 총 크기 반환
    }


}