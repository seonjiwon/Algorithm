package baekjoon.sentences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int[] count = new int[26];
        line = line.toUpperCase();
        for (char c : line.toCharArray()) {
            count[c - 'A']++;
        }

        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            maxCount = Math.max(maxCount, count[i]);
        }

        int maxCountChars = 0;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (count[i] == maxCount) {
                maxCountChars++;
                result = (char) (i + 'A');
            }
        }

        System.out.println(maxCountChars <= 1 ? result : '?');
        br.close();
     }
}
