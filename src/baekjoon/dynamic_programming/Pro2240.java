package baekjoon.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] plums = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            plums[i] = Integer.parseInt(br.readLine());
        }

        // dp[t][w][p] = 시간 t에 w번 이동하여 p 위치에 있을 때 얻을 수 있는 최대 자두 개수
        // p = 1: 1번 나무 아래, p = 2: 2번 나무 아래
        int[][][] dp = new int[T + 1][W + 1][3];

        // 1번 나무에서 시작하므로 초기 상태 설정
        // 시간 1
        if (plums[1] == 1) {
            dp[1][0][1] = 1;
        } else { // plums[1] == 2
            dp[1][1][2] = 1;
        }

        // 시간 2부터 T까지 반복
        for (int t = 2; t <= T; t++) {
            // 이동 횟수 0번일 때
            if (plums[t] == 1) {
                dp[t][0][1] = dp[t - 1][0][1] + 1;
            } else {
                dp[t][0][1] = dp[t - 1][0][1];
            }

            // 이동 횟수 1번부터 W까지
            for (int w = 1; w <= W; w++) {
                // 현재 1번 나무 아래에 있는 경우
                // 1) 이전에도 1번 나무에 있었을 경우 (이동 X)
                // 2) 이전에 2번 나무에 있었을 경우 (이동 O)
                if (plums[t] == 1) {
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]) + 1;
                } else {
                    dp[t][w][1] = Math.max(dp[t - 1][w][1], dp[t - 1][w - 1][2]);
                }

                // 현재 2번 나무 아래에 있는 경우
                // 1) 이전에도 2번 나무에 있었을 경우 (이동 X)
                // 2) 이전에 1번 나무에 있었을 경우 (이동 O)
                if (plums[t] == 2) {
                    dp[t][w][2] = Math.max(dp[t - 1][w][2], dp[t - 1][w - 1][1]) + 1;
                } else {
                    dp[t][w][2] = Math.max(dp[t - 1][w][2], dp[t - 1][w - 1][1]);
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
