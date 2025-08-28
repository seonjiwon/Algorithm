package sentences;

import java.io.*;

public class Pro1515 {

    private static final int maxLength = 3000;

    private static int Solution(String number){

        int pointer = 0;

        for (int base = 1; base <= maxLength * 10; base++) {
            String stringBase = String.valueOf(base);
            for (int i = 0; i < stringBase.length(); i++) {
                if (stringBase.charAt(i) == number.charAt(pointer)) {
                    pointer++;
                }
                if (pointer == number.length()) {
                    return base;
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        int result = Solution(number);
        System.out.println(result);

        br.close();
     }
}
