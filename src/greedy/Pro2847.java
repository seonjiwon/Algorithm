package greedy;

import java.util.*;
import java.io.*;

public class Pro2847 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] levels = new Integer[n];
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }


        int cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            int targetLevel = levels[i + 1] - 1;

            if (levels[i] >= targetLevel) {
                int decrease = levels[i] - targetLevel;

                cnt += decrease;

                levels[i] = targetLevel;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
