package baekjoon.array;

import java.io.*;

public class Pro10808 {

    private static int[] Solution(String str){
        int[] alphabet = new int[26];

        for (char c : str.toCharArray()){
            alphabet[c - 'a']++;
        }

        return alphabet;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] solution = Solution(str);

        StringBuilder sb = new StringBuilder();
        for (int s : solution) {
            sb.append(s + " ");
        }

        System.out.println(sb.toString());

        br.close();
     }

}
