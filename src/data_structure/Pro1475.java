package data_structure;

import java.io.*;

public class Pro1475 {

    private static int Solution(int n){
        int[] numberArray = new int[10];
        String numStr = String.valueOf(n);
        for (char c : numStr.toCharArray()) {
            numberArray[c - '0']++;
        }

        int sixAndNine = (int) Math.round((double)(numberArray[6] + numberArray[9]) / 2);

        int maxValue = 0;
        for (int i = 0; i < numberArray.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            if (maxValue < numberArray[i]){
                maxValue = numberArray[i];
            }
        }

        return Math.max(sixAndNine, maxValue);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        int solution = Solution(number);
        System.out.println(solution);

        br.close();
     }
}
