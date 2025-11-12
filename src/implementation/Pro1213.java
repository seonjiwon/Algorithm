package implementation;

import java.io.*;

public class Pro1213 {

    private static String Solution(String inputStr){

        String result = "I'm Sorry Hansoo";

        //inputStr -> arr
        int[] arr = inputToArr(inputStr);

        //펠린드롬 검증 로직
        int odd = 0;
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                odd++;
                num = i;
            }
            if (odd >= 2) {
                return result;
            }
        }

        //성공 로직
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        result = sb.toString();
        if (odd == 1) {
            result += (char) (num + 'A');
        }

        result += sb.reverse().toString();

        return result;
    }

    private static int[] inputToArr(String inputStr) {
        int[] arr = new int[26];
        for (char c : inputStr.toCharArray()) {
            arr[c - 'A']++;
        }
        return arr;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String result = Solution(str);
        System.out.println(result);

        br.close();
     }

}
