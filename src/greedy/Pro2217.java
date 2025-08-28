package greedy;

import java.util.*;
import java.io.*;

public class Pro2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }

        int solution = solution(N, weights);

        System.out.println(solution);
        br.close();
    }

    private static int solution(int n, int[] weights) {
        int result = 0;
        Arrays.sort(weights);

        for (int i = n - 1; i >= 0; i--) {
            result = Math.max(result, weights[i] * (n - i));
        }

        return result;
    }
}
