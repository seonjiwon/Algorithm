package binary_search;

import java.io.*;
import java.util.*;

public class Pro1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringTokenizer stA = new StringTokenizer(br.readLine());

        int[] arrayA = new int[A];
        for (int i = 0; i < A; i++) {
            arrayA[i] = Integer.parseInt(stA.nextToken());
        }

        StringTokenizer stB = new StringTokenizer(br.readLine());
        int[] arrayB = new int[B];
        for (int i = 0; i < B; i++) {
            arrayB[i] = Integer.parseInt(stB.nextToken());
        }

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        List<Integer> solution = solution(arrayA, arrayB);

        if (solution.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(solution.size());
            for (Integer i : solution) {
                System.out.print(i + " ");
            }
        }

        br.close();
    }

    private static List<Integer> solution(int[] arrayA, int[] arrayB) {
        List<Integer> result = new ArrayList<>();

        for (int target : arrayA) {
            int start = 0;
            int end = arrayB.length - 1;
            boolean flag = false;

            int mid;
            while (start <= end) {
                mid = (start + end) / 2;

                if (target == arrayB[mid]) {
                    flag = true;
                    break;
                }

                if (target > arrayB[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (!flag) {
                result.add(target);
            }
        }

        return result;
    }
}
