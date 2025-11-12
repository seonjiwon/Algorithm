package dp;

import java.io.*;

public class Pro2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] beverage = new int[n+1];
        int[] dp = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            beverage[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = beverage[1];

        if (n > 1) {
            dp[2] = beverage[1] + beverage[2];
        }

        for (int i = 3; i < n + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + beverage[i], dp[i - 3] + beverage[i - 1] + beverage[i]));
        }

        System.out.println(dp[n]);
        br.close();
    }
}
