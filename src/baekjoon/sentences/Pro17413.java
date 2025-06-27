package baekjoon.sentences;

import java.io.*;
import java.util.*;

public class Pro17413 {
    private static String Solution(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder noChange = new StringBuilder();

        boolean isFlag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '>') {
                noChange.append(">");
                isFlag = false;
                continue;
            } else if (c == '<') {
                noChange.append(sb.reverse());
                sb.setLength(0);
                isFlag = true;
            }


            if (isFlag) {
                noChange.append(String.valueOf(c));
                continue;
            }

            if (c == ' ') {
                noChange.append(sb.reverse());
                sb.setLength(0);
                noChange.append(' ');
                continue;
            }

            sb.append(c);
        }

        return noChange.toString() + sb.reverse();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        String result = Solution(string);


        System.out.println(result);

        br.close();
    }
}
