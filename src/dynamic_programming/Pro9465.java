package dynamic_programming;

import java.util.*;
import java.io.*;

public class Pro9465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];

            for (int i = 0; i < 2; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    sticker[i][j] = Integer.parseInt(line[j]);
                }
            }

            int solution = solution(sticker, n);
            System.out.println(solution);
        }

        br.close();
    }

    private static int solution(int[][] sticker, int n) {
        int[][] dp = new int[2][n];

        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];

        for (int i = 1; i < n; i++) {
            if (i >= 2) {
                dp[0][i] = sticker[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
                dp[1][i] = sticker[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
            } else {
                dp[0][i] = sticker[0][i] + dp[1][i - 1];
                dp[1][i] = sticker[1][i] + dp[0][i - 1];
            }
        }

        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }
}
