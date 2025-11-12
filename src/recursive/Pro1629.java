package recursive;

import java.util.*;
import java.io.*;

public class Pro1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long solution = solution(A, B, C);
        System.out.println(solution);
        br.close();
    }

    public static long solution(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }

        long temp = solution(a, b / 2, c);

        long result = (temp * temp) % c;

        if (b % 2 != 0) {
            result = (result * a) % c;
        }

        return result;
    }
}
