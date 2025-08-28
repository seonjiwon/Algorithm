package array;

import java.io.*;
import java.util.*;

public class Pro2577 {

    private static int[] Solution(int n){
        int[] result = new int[10];

        String str = String.valueOf(n);
        for(char c : str.toCharArray()){
            result[c - '0']++;
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());

        int[] solution = Solution(n1 * n2 * n3);

        for (int i : solution) {
            System.out.println(i);
        }

        br.close();
     }
}
