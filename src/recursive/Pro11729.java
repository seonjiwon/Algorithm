package recursive;

import java.io.*;

public class Pro11729 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        solution(N, 1, 2, 3, sb);

        System.out.println(cnt);
        System.out.println(sb);
        br.close();
    }

    private static void solution(int n, int start, int mid, int to, StringBuilder sb) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            cnt++;
            return;
        }

        // A -> C로 옮길때
        // 우선 N-1 개를 A -> B 로 옮김
        solution(n - 1, start, to, mid, sb);

        // 1개를 A -> C 로 이동
        sb.append(start + " " + to + "\n");
        cnt++;

        // N-1 개를 B -> C로 이동
        solution(n - 1, mid, start, to, sb);
    }
}
