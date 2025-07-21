package baekjoon.array;

import java.io.*;
import java.util.*;

public class Pro11328 {
    private static String Solution(String[] arr) {
        int[] alphabet = new int[26];


        for (char c : arr[0].toCharArray()) {
            alphabet[c-'a']++;
        }

        for (char c : arr[1].toCharArray()) {
            alphabet[c-'a']--;
        }

        for (int i : alphabet) {
            if (i != 0) {
                return "Impossible";
            }
        }

        return "Possible";
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String[] split = br.readLine().split(" ");
            String solution = Solution(split);
            System.out.println(solution);
        }

        br.close();
    }
}
