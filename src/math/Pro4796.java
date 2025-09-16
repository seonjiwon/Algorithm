package math;

import java.util.*;
import java.io.*;

public class Pro4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 1;
        while (true) {
            String[] input = br.readLine().split(" ");
            int L = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            int V = Integer.parseInt(input[2]);

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int result = 0;

            result = (V / P) * L;
            if (V % P <= L) {
                result += V % P;
            } else {
                result += L;
            }
            System.out.printf("Case %d: %d", i, result);
            System.out.println();
            i++;
        }

        br.close();
     }
}
