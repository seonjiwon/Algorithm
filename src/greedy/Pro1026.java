package greedy;

import java.util.*;
import java.io.*;

public class Pro1026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] aInput = br.readLine().split(" ");
        String[] bInput = br.readLine().split(" ");

        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(aInput[i]);
            b[i] = Integer.parseInt(bInput[i]);
        }

        int solution = solution(N, a, b);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int n, int[] a, int[] b) {
        int result = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            result += b[i] * a[n - i - 1];
        }

        return result;
    }
}
