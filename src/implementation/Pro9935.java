package implementation;

import java.io.*;

public class Pro9935 {
    private static String Solution(String str, String bomb){
        StringBuilder sb = new StringBuilder();
        int bombLength = bomb.length();


        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bombLength) {
                boolean isBomb = true;
                for (int j = 0; j < bombLength; j++) {
                    if (sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)) {
                        isBomb = false;
                    }
                }

                if (isBomb) {
                    sb.setLength(sb.length() - bombLength);
                }
            }


        }

        return sb.length() == 0 ? "FRULA" : sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        String solution = Solution(str, bomb);
        System.out.println(solution);

        br.close();
     }
}
