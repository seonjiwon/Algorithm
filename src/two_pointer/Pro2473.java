package two_pointer;

import java.util.*;
import java.io.*;

public class Pro2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] liquid = new long[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 정렬
        Arrays.sort(liquid);

        long[] result = new long[3];
        long closeZero = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            // 2. 값 하나 select
            long fixedValue = liquid[i];

            // 3. 나머지 두개 값 투 포인터
            int start = i + 1;
            int end = N - 1;

            while (start < end) {
                long sum = fixedValue + liquid[start] + liquid[end];
//                System.out.println("sum: " + sum);

                if (Math.abs(0 - sum) < closeZero) {
//                    System.out.println("first: " + fixedValue + ", second: " + liquid[start] + ", third: " + liquid[end]);
                    result[0] = fixedValue;
                    result[1] = liquid[start];
                    result[2] = liquid[end];
                    closeZero = Math.abs(0 - sum);
//                    System.out.println("closeZero: " + closeZero);
                }

                if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (long i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
