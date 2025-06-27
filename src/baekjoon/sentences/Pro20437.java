package baekjoon.sentences;

import java.io.*;
import java.util.*;

public class Pro20437 {

    private static List<Integer> Solution(String str, int k) {
        if (k == 1) return List.of(1, 1);

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int target = 'a'; target <= 'z'; target++) {
            int count = 0;
            int left = 0;

            for (int right = 0; right < str.length(); right++) {
                if (str.charAt(right) == target) {
                    count++;
                }

                // target이 k개가 되면 left ++;
                while (count == k) {
                    minLength = Math.min(minLength, right - left + 1);
                    if (str.charAt(left) == target) {
                        maxLength = Math.max(maxLength, right - left + 1);
                        count--;
                    }
                    left++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE || maxLength == Integer.MIN_VALUE ? List.of(-1) : List.of(minLength, maxLength);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String W;
        int K;
        while (T-- > 0) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            List<Integer> solution = Solution(W, K);

            for (Integer i : solution) {
                System.out.print(i + " ");
            }

        }

        br.close();
    }
}
