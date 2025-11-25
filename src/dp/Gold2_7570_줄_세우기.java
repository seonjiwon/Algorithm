package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold2_7570_줄_세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            dp[k] = dp[k-1] + 1;
            maxValue = Math.max(maxValue, dp[k]);
        }

        System.out.println(N - maxValue);

        br.close();
    }
}
