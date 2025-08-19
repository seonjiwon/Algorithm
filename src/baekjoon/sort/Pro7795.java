package baekjoon.sort;

import java.io.*;
import java.util.*;

public class Pro7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] size = br.readLine().split(" ");
            int N = Integer.parseInt(size[0]), M = Integer.parseInt(size[1]);
            String[] line1 = br.readLine().split(" ");
            String[] line2 = br.readLine().split(" ");

            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(line1[i]);
            }

            int[] B = new int[M];
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(line2[i]);
            }

            int result = sort(A, B);
            System.out.println(result);
        }

        br.close();
     }

    private static int sort(int[] a, int[] b){
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            int aNumber = a[i];
            for (int j = 0; j < b.length; j++) {
                int bNumber = b[j];
                if (aNumber > bNumber) {
                    result++;
                }
            }
        }

        return result;
    }
}
