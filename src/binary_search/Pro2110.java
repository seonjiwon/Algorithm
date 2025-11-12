package binary_search;

import java.util.*;
import java.io.*;

public class Pro2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] location = new int[N];
        for (int i = 0; i < N; i++) {
            location[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(location);

        // 해답
        System.out.println(solution(location, N, C));

        br.close();
    }

    private static int solution(int[] arr, int n, int c) {
        int low = 1;
        int high = arr[n - 1] - arr[0];

        while (low <= high) { // low == high 까지 계산 해야됨 ex) 5, 6 => mid = 5 / 6, 6 mid = 6
            int mid = (low + high) / 2;

            int position = 0;
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (arr[i] - arr[position] >= mid) {
                    position = i;
                    cnt++;
                }
            }

            if (cnt < c) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
    }

}
