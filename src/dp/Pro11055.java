package dp;

import java.io.*;

public class Pro11055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] numbers = convertToNumbers(n, inputs);
        int result = solution(n, numbers);

        System.out.println(result);
        br.close();
     }

    private static int[] convertToNumbers(int n, String[] inputs) {
        int[] response = new int[n];
        for (int i = 0; i < n; i++) {
            response[i] = Integer.parseInt(inputs[i]);
        }

        return response;
    }

    private static int solution(int n, int[] numbers) {
        int[] dp = new int[n];

        // 각 dp 의 값을 초기화
        for (int i = 0; i < n; i++) {
            dp[i] = numbers[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    // 이전 값에 현재값 더하기 vs 현재값
                    dp[i] = Math.max(dp[i], numbers[i] + dp[j]);
                }
            }
        }

        int maxSum = 0;
        for (int i : dp) {
            maxSum = Math.max(maxSum, i);
        }

        return maxSum;
    }
}
