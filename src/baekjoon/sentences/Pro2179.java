package baekjoon.sentences;

import java.io.*;
import java.util.*;

public class Pro2179 {

    private static String[] Solution(List<String> words){
        String[] result = new String[2];

        int maxCharLength = 0;
        for (int i = 0; i < words.size(); i++) {
            String baseWord = words.get(i);
            for (int j = i+1; j < words.size(); j++) {

                int sameCharLength = 0;

                String compareWord = words.get(j);
                for (int k = 0; k < baseWord.length(); k++) {
                    if (k >= compareWord.length()) {
                        break;
                    }
                    if (baseWord.charAt(k) == compareWord.charAt(k)){
                        sameCharLength++;
//                        System.out.println("baseWord = " + baseWord);
//                        System.out.println("compareWord = " + compareWord);
                    } else {
                        break;
                    }
                }

                if (sameCharLength > maxCharLength) {
                    maxCharLength = sameCharLength;
                    result[0] = baseWord;
                    result[1] = compareWord;
                }

            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        while (N-- > 0){
            words.add(br.readLine());
        }

        String[] solution = Solution(words);
        for (String string : solution) {
            System.out.println(string);
        }

        br.close();
     }
}
