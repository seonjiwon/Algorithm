package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro2240_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plums = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            plums[i] = Integer.parseInt(br.readLine());
        }

        // 현재 시간, 움직인 수, 현재 위치
        int[][][] dp = new int[T + 1][W + 1][3];

        if (plums[1] == 1) {
            dp[1][0][1] = 1;
        } else { // plums[1] == 2
            dp[1][1][2] = 1;
        }

        for (int i = 2; i < T + 1; i++) {
            // 이동 횟수 0번일 때
            if (plums[i] == 1) {
                dp[i][0][1] = dp[i - 1][0][1] + 1;
            } else {
                dp[i][0][1] = dp[i - 1][0][1];
            }

            // 이동 횟수가 1 ~ W 일 때
            for (int j = 1; j < W + 1; j++) {
                // 현재 1번 나무 아래에 있는 경우
                // 1) 이전에도 1번 나무에 있었을 경우 (이동 X)
                // 2) 이전에 2번 나무에 있었을 경우 (이동 O)
                if (plums[i] == 1) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                } else {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                }

                // 현재 2번 나무 아래에 있는 경우
                // 1) 이전에도 2번 나무에 있었을 경우 (이동 X)
                // 2) 이전에 1번 나무에 있었을 경우 (이동 O)
                if (plums[i] == 2) {
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
                } else {
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
                }
            }
        }

        int maxPlums = 0;
        for (int w = 0; w <= W; w++) {
            maxPlums = Math.max(maxPlums, Math.max(dp[T][w][1], dp[T][w][2]));
        }

        System.out.println(maxPlums);

        br.close();
    }
}
