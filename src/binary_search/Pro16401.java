package binary_search;

import java.util.*;
import java.io.*;

public class Pro16401 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cookies = new int[M];
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            cookies[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(cookies);

        int solution = solution(N, M, cookies);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int n, int m, int[] cookies) {
        int result = 0;

        int start = 1;
        int end = cookies[m-1];
        int mid;

        while (start <= end) {
            int count = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < m; i++) {
                count += cookies[i] / mid;
            }

            if (count >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return result;
    }
}
