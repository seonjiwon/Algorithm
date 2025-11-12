package two_pointer;

import java.io.*;
import java.util.StringTokenizer;

public class Pro13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, arr));

        br.close();
    }

    private static long solution(int n, int[] arr) {
        long cnt = 0;

        int[] visited = new int[100_001];
        int start = 0;

        for (int end = 0; end < n; end++) {
            while (visited[arr[end]] > 0) {
                visited[arr[start]]--;
                start++;
            }

            visited[arr[end]]++;

            cnt += end - start + 1;
        }

        return cnt;
    }
}
