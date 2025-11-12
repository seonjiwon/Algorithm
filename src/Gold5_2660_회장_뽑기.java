import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold5_2660_회장_뽑기 {
    static int N;
    static List<Integer>[] link;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        link = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

            if (u == -1 && v == -1) {
                break;
            }

            link[u].add(v);
            link[v].add(u);
        }

        int minValue = Integer.MAX_VALUE;
        int[] applicant = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            int score = solution(i);
            minValue = Math.min(score, minValue);
            applicant[i] = score;
        }

        List<Integer> candidate = new ArrayList<>();
        for (int i = 0; i < applicant.length; i++) {
            if (applicant[i] == minValue) {
                candidate.add(i);
            }
        }

        System.out.println(minValue + " " + candidate.size());
        Collections.sort(candidate);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < candidate.size(); i++) {
            sb.append(candidate.get(i)).append(" ");
        }
        System.out.println(sb);

        br.close();
    }

    private static int solution(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int maxDepth = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int u = current[0];
            int depth = current[1];

            for (Integer v : link[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new int[]{v, depth + 1});
                    maxDepth = Math.max(maxDepth, depth + 1);
                }
            }
        }

        return maxDepth;
    }
}
