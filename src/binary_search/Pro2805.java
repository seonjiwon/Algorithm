package binary_search;

import java.util.*;
import java.io.*;

public class Pro2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(trees);

        int solution = solution(N, M, trees);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int n, int target, int[] trees) {
        int result = 0;

        int start = 1;
        int end = trees[n-1];
        int mid;

        while (start <= end) {
            long length = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {
                length += Math.max(trees[i] - mid, 0);
            }

            if (length >= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return result;
    }
}
