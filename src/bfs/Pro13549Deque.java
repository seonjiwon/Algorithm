package bfs;

import java.io.*;
import java.util.*;

public class Pro13549Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]), K = Integer.parseInt(split[1]);

        int result = leastPathToSister(N, K);
        System.out.println(result);

        br.close();
    }

    private static int leastPathToSister(int n, int k) {
        // Deque를 사용한 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{n, 0});

        boolean[] visited = new boolean[100_001];

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int pos = current[0], time = current[1];

            if (pos == k) return time;
            if (visited[pos]) continue;
            visited[pos] = true;

            // 순간이동 (시간 0) - 덱의 앞쪽에 추가
            if (pos * 2 <= 100_000 && !visited[pos * 2]) {
                deque.offerFirst(new int[]{pos * 2, time});
            }

            // 걷기 (시간 1) - 덱의 뒤쪽에 추가
            if (pos - 1 >= 0 && !visited[pos - 1]) {
                deque.offerLast(new int[]{pos - 1, time + 1});
            }
            if (pos + 1 <= 100_000 && !visited[pos + 1]) {
                deque.offerLast(new int[]{pos + 1, time + 1});
            }
        }

        return -1;
    }
}
