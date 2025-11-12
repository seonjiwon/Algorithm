package two_pointer;

import java.util.*;
import java.io.*;

public class Pro2003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(arr, N, M);
        System.out.println(result);

        br.close();
    }

    private static int solution(int[] arr, int n, int m) {

        int left = 0, right = 0, sum = 0, cnt = 0;

        while (true) {
            if (sum >= m) {
                sum -= arr[left++];
            } else if (right == n) {
                break;
            } else {
                sum += arr[right++];
            }

            if (sum == m) {
                cnt++;
            }
        }

        return cnt;
    }
}
