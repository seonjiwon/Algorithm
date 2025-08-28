package greedy;

import java.util.*;
import java.io.*;

public class Pro11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] prices = br.readLine().split(" ");
            int[] stocks = new int[N];

            for (int i = 0; i < N; i++) {
                stocks[i] = Integer.parseInt(prices[i]);
            }

            long result = solution(N, stocks);
            System.out.println(result);
        }

        br.close();
    }

    private static long solution(int n, int[] stocks) {
        long result = 0;
        int maxPrice = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (stocks[i] > maxPrice) {
                maxPrice = stocks[i];
            } else {
                result += maxPrice - stocks[i];
            }
        }
        return result;
    }
}
