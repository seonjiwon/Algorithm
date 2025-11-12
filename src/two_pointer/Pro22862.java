package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pro22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr, N, K));

        br.close();
    }

    private static int solution(int[] arr, int n, int k) {
        int result = 0;

        int start = 0;
        int end = 0;

        int[] numbers = new int[2];

        while (end < n) {
            if (numbers[1] > k) {
                numbers[arr[start] % 2]--;
                start++;
            }

            if (arr[end] % 2 == 0) {
                numbers[0]++;
            } else {
                numbers[1]++;
            }
            end++;

            if (numbers[1] <= k) {
                result = Math.max(numbers[0], result);
            }
        }

        return result;
    }
}
