package baekjoon.sentences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro9046 {

    private static char Solution(String str) {
        int[] count = new int[26];

        for (char c : str.toCharArray()) {
            if (c != ' ') {
                count[c - 'a']++;
            }
        }

        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(count[i], maxCount);
        }

        int maxCountChars = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] == maxCount) {
                maxCountChars++;
                result = (char) (i + 'a');
            }
        }

        return maxCountChars <= 1 ? result : '?';
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String str = br.readLine();
            System.out.println(Solution(str));
        }
        br.close();
     }
}
