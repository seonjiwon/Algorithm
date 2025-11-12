package dp;

import java.util.*;
import java.io.*;

public class Pro14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        int[] path = new int[N];

        for (int i = 0; i < N; i++) {
            path[i] = i;
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            boolean flag = false;

            for (int j = 0; j < N - 1; j++) {
                if (array[j] < array[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    path[i] = j;
                    flag = true;
                }
            }

            if (!flag) {
                path[i] = -1;
            }
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }

        System.out.println(max);

        StringBuilder sb = new StringBuilder();
        while (idx != -1) {
            int arr = array[idx];
            sb.insert(0, arr + " ");
            idx = path[idx];
        }

        System.out.println(sb);
        br.close();
    }
}
