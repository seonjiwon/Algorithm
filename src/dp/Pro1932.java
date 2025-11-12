package dp;

import java.io.*;

public class Pro1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + triangle[i][j]);
                if (j + 1 < n) {
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i-1][j] + triangle[i][j+1]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp[n-1][i];
            result = Math.max(result, temp);
        }

        System.out.println(result);

        br.close();
     }
}
