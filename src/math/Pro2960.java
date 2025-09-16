package math;

import java.util.*;
import java.io.*;

public class Pro2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int solution = solution(N, K);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int n, int k) {
        int[] numbers = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            numbers[i] = i;
        }

        int remove = 0;
        while (true) {
            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j <= n / i; j++) {
                    if (numbers[i * j] != 0) {
                        numbers[i * j] = 0;
                        remove++;

                        if (remove == k) {
                            return i * j;
                        }
                    }
                }
            }
        }
    }
}
