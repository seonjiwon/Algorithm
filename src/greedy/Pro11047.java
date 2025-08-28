package greedy;

import java.util.*;
import java.io.*;

public class Pro11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int solution = solution(coins, N, K);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int[] coins, int n, int k) {
        int result = 0;

        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];

            if (k / coin > 0) {
                result += k / coin;
                k = k % coin;
            }
        }

        return result;
    }
}
