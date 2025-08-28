package sentences;

import java.io.*;
import java.util.*;

public class Pro1522 {

    private static int Solution(String str){
        int slide = countCh(str, 'a');
        int minB = Integer.MAX_VALUE;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < slide; j++) {
                sb.append(str.charAt((i + j) % str.length()));
            }

            int b = countCh(sb.toString(), 'b');
            minB = Math.min(minB, b);

            sb.setLength(0);
        }

        return minB;
    }

    private static int countCh(String str, char target){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int solution = Solution(str);
        System.out.println(solution);

        br.close();
     }

}
