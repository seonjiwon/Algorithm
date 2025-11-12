package dp;

import java.io.*;

public class Pro9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long result = solution(n);
            System.out.println(result);
        }

        br.close();
     }

    private static long solution(int n) {
        long[] dp = new long[Math.max(3, n)];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;


        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }


        return dp[n-1];
    }
}
