package math;

import java.util.*;
import java.io.*;

public class Pro2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int nTwoResult = getCount(n, 2) - getCount(m, 2) - getCount(n - m, 2);
        int nFiveResult = getCount(n, 5) - getCount(m, 5) - getCount(n - m, 5);
        System.out.println(Math.min(nTwoResult, nFiveResult));

        br.close();
    }

    private static int getCount(int number, int target) {
        int result = 0;
        while (number >= target) {
            result += number / target;
            number = number / target;
        }
        return result;
    }
}
