import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold5_15681_트리와_쿼리 {
    static List<Integer>[] link;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());

        link = new ArrayList[N + 1];
        cnt = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
            link[u].add(v);
            link[v].add(u);
        }

        dfs(R, -1);
        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            System.out.println(cnt[U]);
        }

        br.close();
    }

    private static void dfs(int u, int parentNode) {
        cnt[u] = 1;

        for (int v : link[u]) {
            if (v != parentNode) {
                dfs(v, u);
                cnt[u] += cnt[v];
            }
        }
    }
}
