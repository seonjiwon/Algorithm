package dp;

import java.io.*;

public class Pro1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] paintCost = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] costs = br.readLine().split(" ");
            paintCost[i][0] = Integer.parseInt(costs[0]);
            paintCost[i][1] = Integer.parseInt(costs[1]);
            paintCost[i][2] = Integer.parseInt(costs[2]);
        }

        int result = solution(N, paintCost);

        System.out.println(result);

        br.close();
     }

    private static int solution(int n, int[][] paintCost) {
        int[][] dp = new int[n][3];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = paintCost[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = paintCost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = paintCost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = paintCost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Integer.MAX_VALUE;
        for (int i : dp[n - 1]) {
            result = Math.min(result, i);
        }

        return result;
    }
}
