package greedy;

import java.io.*;
import java.util.*;

public class Pro1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(num);
            } else if (num == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        Collections.sort(positives, Collections.reverseOrder());
        Collections.sort(negatives);

        long solution = solution(oneCount, positives, negatives, zeroCount);

        System.out.println(solution);

        br.close();
    }

    private static long solution(int oneCount, List<Integer> positives, List<Integer> negatives, int zeroCount) {
        long sum = 0;
        sum += oneCount;

        // 양수 처리
        for (int i = 0; i < positives.size(); i += 2) {
            if (i + 1 < positives.size()) {
                sum += (long) positives.get(i) * positives.get(i + 1);
            } else {
                sum += positives.get(i);
            }
        }

        // 음수 처리
        for (int i = 0; i < negatives.size(); i += 2) {
            if (i + 1 < negatives.size()) {
                sum += (long) negatives.get(i) * negatives.get(i + 1);
            } else {
                if (zeroCount <= 0) {
                    sum += negatives.get(i);
                }
            }
        }
        return sum;
    }
}
