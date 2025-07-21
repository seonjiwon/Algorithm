package baekjoon.array;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1919 {
    private static int Solution(String[] arr) {
        int result = 0;
        int[] alphabet = new int[26];

        for (char c : arr[0].toCharArray()) {
            alphabet[c-'a']++;
        }

        for (char c : arr[1].toCharArray()) {
            alphabet[c-'a']--;
        }

        for (int i : alphabet) {
            if (i != 0) {
                result += Math.abs(i);
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String[] str = {str1, str2};
        int solution = Solution(str);
        System.out.println(solution);
        br.close();
    }
}
