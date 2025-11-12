package dp;

import java.io.*;

public class Pro2302 {

    static boolean[] seating;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        seating = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            seating[Integer.parseInt(br.readLine())] = true;
        }
        System.out.println(solution(N, M));

        br.close();
    }

    private static int solution(int n, int m) {
        // 공연 좌석 별 경우의 수
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        if (n >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // vip 좌석 사이 좌석의 갯수 구해서 경우의 수 도출
        int result = 1;
        int beforeSeat = 0;

        for (int i = 1; i <= n; i++) {
            if (seating[i]) {
                result *= dp[i - beforeSeat - 1];
                beforeSeat = i;
            }
        }

        result *= dp[n - beforeSeat];
        return result;
    }
}
