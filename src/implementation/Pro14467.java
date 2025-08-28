package implementation;

import java.io.*;
import java.util.*;

public class Pro14467 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cowPosition = new int[N+1];
        Arrays.fill(cowPosition, 2);

        int result = 0;

        while (N-- > 0) {
            String[] split = br.readLine().split(" ");
            int cowNum = Integer.parseInt(split[0]);
            int position = Integer.parseInt(split[1]);
            if (cowPosition[cowNum] == 2) {
                cowPosition[cowNum] = position;
            } else {
                if (cowPosition[cowNum] != position) {
                    result++;
                    cowPosition[cowNum] = position;
                }
            }
        }

        System.out.println(result);
        br.close();
     }
}
