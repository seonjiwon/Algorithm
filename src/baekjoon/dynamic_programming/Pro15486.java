package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro15486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N + 1];
        int[] p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            t[i] = Integer.parseInt(line[0]);
            p[i] = Integer.parseInt(line[1]);
        }

        int[] dp = new int[N + 2];

        for (int i = N; i >= 1; i--) {
            int endDay = i + t[i];

            if (endDay <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[endDay] + p[i]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);

        br.close();
    }

}
