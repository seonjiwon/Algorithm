package implementation;

import java.util.*;
import java.io.*;

public class Pro11559 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String row = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        int result = 0;

        // 연쇄가 발생하는 동안 반복
        while (true) {
            visited = new boolean[12][6];
            boolean hasChain = false;

            // 터뜨릴 수 있는 블록들을 모두 찾기
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!visited[i][j] && map[i][j] != '.') {
                        if (bfs(i, j, map[i][j])) {
                            hasChain = true;
                        }
                    }
                }
            }

            // 터뜨릴 블록이 없으면 종료
            if (!hasChain) break;

            // 터뜨린 블록들을 '.'으로 변경
            removeBlocks();

            // 블록들을 아래로 떨어뜨리기
            dropBlocks();

            result++;
        }

        System.out.println(result);
        br.close();
    }

    private static boolean bfs(int startY, int startX, char ch) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> blocks = new ArrayList<>();

        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;
        blocks.add(new int[]{startY, startX});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0], x = current[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];

                if (nx >= 0 && nx < 6 && ny >= 0 && ny < 12) {
                    if (map[ny][nx] == ch && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                        blocks.add(new int[]{ny, nx});
                    }
                }
            }
        }

        // 4개 이상이면 터뜨릴 블록으로 표시
        if (blocks.size() >= 4) {
            for (int[] block : blocks) {
                map[block[0]][block[1]] = '0';  // 터뜨릴 표시
            }
            return true;
        }

        return false;
    }

    private static void removeBlocks() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] == '0') {
                    map[i][j] = '.';
                }
            }
        }
    }

    private static void dropBlocks() {
        for (int j = 0; j < 6; j++) {
            int bottom = 11;

            // 아래에서부터 위로 올라가면서 블록을 아래로 이동
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    map[bottom][j] = map[i][j];
                    if (bottom != i) {
                        map[i][j] = '.';
                    }
                    bottom--;
                }
            }
        }
    }
}