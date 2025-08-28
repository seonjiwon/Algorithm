package dynamic_programming;

import java.util.*;
import java.io.*;

public class Pro1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[n];

        dp[0] = arr[0];

        int max_sum = arr[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);

            max_sum = Math.max(max_sum, dp[i]);
        }

        System.out.println(max_sum);
        br.close();
    }
}
