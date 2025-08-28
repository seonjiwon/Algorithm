package dfs;

import java.io.*;
import java.util.*;

public class Pro9466 {
    static int N;

    static int[] linkList;
    static boolean[] visited;  // 방문 여부
    static boolean[] finished; // 탐색 완료 여부

    static int cycleCount;     // 사이클에 포함된 노드 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            N = Integer.parseInt(br.readLine());
            linkList = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            cycleCount = 0;

            String[] split = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                linkList[i + 1] = Integer.parseInt(split[i]);
            }

            // 모든 노드에 대해 DFS 수행
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - cycleCount);
        }
        br.close();
    }

    private static void dfs(int node) {
        visited[node] = true;
        int next = linkList[node];

        if (!visited[next]) {
            // 다음 노드가 미방문이면 계속 탐색
            dfs(next);
        } else if (!finished[next]) {
            // 다음 노드가 방문됐지만 탐색이 완료되지 않음 = 사이클 발견
            // 사이클 크기 계산
            for (int temp = next; temp != node; temp = linkList[temp]) {
                cycleCount++;
            }
            cycleCount++; // node 자신도 포함
        }

        finished[node] = true; // 현재 노드 탐색 완료
    }
}
