package dynamic_programming;

import java.util.*;
import java.io.*;

public class Pro14501 {
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

        for (int i = 1; i <= N + 1; i++) {

            if (i <= N + 1) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }

            if (i <= N) {
                int endDay = i + t[i];
                if (endDay <= N + 1) {
                    dp[endDay] = Math.max(dp[endDay], dp[i] + p[i]);
                }
            }
        }

        System.out.println(dp[N+1]);

        br.close();
    }
}
