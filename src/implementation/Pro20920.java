package implementation;

import java.io.*;
import java.util.*;

public class Pro20920 {
    private static List<String> Solution(Map<String, Integer> words) {
        List<String> keySet = new ArrayList<>(words.keySet());

        keySet.sort((s1, s2) -> {
            int freqCompare = words.get(s2).compareTo(words.get(s1));
            if (freqCompare != 0) {
                return freqCompare;
            }

            int lengthCompare = Integer.compare(s2.length(), s1.length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }

            return s1.compareTo(s2);
        });

        return keySet;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        // N 단어의 갯수, M 최소 길이
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        Map<String, Integer> words = new HashMap<>();
        while (N-- > 0) {
            String word = br.readLine();
            if (word.length() >= M) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<String> solution = Solution(words);

        StringBuilder sb = new StringBuilder();
        for (String word : solution) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);

        br.close();
    }
}
