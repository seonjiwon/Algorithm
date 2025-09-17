package math;

import java.util.*;
import java.io.*;

public class Pro4948 {
    static boolean[] isPrime = new boolean[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        countPrime();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            int count = 0;

            for (int i = N + 1; i <= 2 * N; i++) {
                if(!isPrime[i]) count++;
            }
            System.out.println(count);
        }

        br.close();
    }

    private static void countPrime() {
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i < Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) continue;

            for (int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
}
