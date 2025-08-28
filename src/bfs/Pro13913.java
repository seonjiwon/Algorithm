package bfs;

import java.util.*;
import java.io.*;

public class Pro13913 {

    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        visited = new boolean[100_001];
        parent = new int[100_001];
        Arrays.fill(parent, -1);

        int time = bfs(N, K);

        System.out.println(time);


        List<Integer> path = new ArrayList<>();
        int p = K;
        while (parent[p] != -1) {
            path.add(p);
            p = parent[p];
        }
        path.add(N);

        Collections.reverse(path);
        for (Integer i : path) {
            System.out.print(i + " ");
        }
        br.close();
     }

    private static int bfs(int n, int k){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});
        visited[n] = true;


        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int currentNode = current[0];
            int time = current[1];

            if (currentNode == k) return time;

            int[] nextSteps = {
                    currentNode + 1,
                    currentNode - 1,
                    currentNode * 2
            };

            for (int next : nextSteps) {

                if (next >= 0 && next <= 100000 && !visited[next]) {
                    parent[next] = currentNode;
                    visited[next] = true;
                    queue.offer(new int[]{next, time + 1});
                }
            }

        }

        return -1;
    }
}
