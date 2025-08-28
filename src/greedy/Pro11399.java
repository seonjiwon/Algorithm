package greedy;

import java.util.*;
import java.io.*;

public class Pro11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] p = new int[N];

        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(inputs[i]);
        }

        int solution = solution(N, p);

        System.out.println(solution);

        br.close();
     }

    private static int solution(int n, int[] p) {
        int result = 0;

        Arrays.sort(p);

        int[] dp = new int[n];
        dp[0] = p[0];

        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + p[i];
        }

        for (int i = 0; i < n; i++) {
            result += dp[i];
        }

        return result;
    }
}
