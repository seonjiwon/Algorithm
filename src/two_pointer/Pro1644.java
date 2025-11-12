package two_pointer;

import java.util.*;
import java.io.*;

public class Pro1644 {

    private static final int MAX_NUMBER = 4_000_000;

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> primeList = new ArrayList<>();
//
//        for (int i = 2; i <= MAX_NUMBER; i++) {
//            if (isPrime(i)) {
//                primeList.add(i);
//            }
//        }
//
//        int target = Integer.parseInt(br.readLine());
//
//        int start = 0, end = 0, sum = 0, cnt = 0;
//        while (start < primeList.size()) {
//            if (sum >= target || end == primeList.size()) {
//                if (sum == target) {
//                    cnt++;
//                }
//                sum -= primeList.get(start++);
//            } else {
//                sum += primeList.get(end++);
//            }
//        }
//
//        System.out.println(cnt);
//        br.close();
//    }
//
//    private static boolean isPrime(int n) {
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[MAX_NUMBER + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX_NUMBER; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX_NUMBER; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 0; i <= MAX_NUMBER; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }

        int target = Integer.parseInt(br.readLine());

        int start = 0, end = 0, sum = 0, cnt = 0;
        while (start < primeList.size()) {
            if (sum >= target || end == primeList.size()) {
                if (sum == target) {
                    cnt++;
                }
                sum -= primeList.get(start++);
            } else {
                sum += primeList.get(end++);
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
