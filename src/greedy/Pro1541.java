package greedy;

import java.util.*;
import java.io.*;

public class Pro1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 우선 - 로 split
        String[] plusRow = br.readLine().split("-");

        // 이후 + 로 split
        int result = 0;

        for (int i = 0; i < plusRow.length; i++) {
            int temp = 0;
            String[] split = plusRow[i].split("\\+");
            for (String s : split) {
                temp += Integer.parseInt(s);
            }

            if (i == 0) {
                result += temp;
            } else {
                result -= temp;
            }
        }
        System.out.println(result);

        br.close();
     }
}
