package binary_search;

import java.util.*;
import java.io.*;

public class Pro2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] liquid = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(liquid);

        // 두 포인터
        int left = 0;
        int right = N - 1;

        int[] result = new int[2];
        int closeZero = Integer.MAX_VALUE;
        while (left < right) {
//            System.out.println(left + ", " + right);
            int sum = liquid[left] + liquid[right];

            if (Math.abs(0 - sum) < closeZero) {
                result[0] = liquid[left];
                result[1] = liquid[right];
                closeZero = Math.abs(0 - sum);
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.printf("%d %d", result[0], result[1]);

        br.close();
    }
}
