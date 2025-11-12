package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro9613 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] lines = br.readLine().split(" ");
            int t = Integer.parseInt(lines[0]);

            long result = 0;
            for (int i = 1; i < t; i++) {
                for (int j = i + 1; j < t + 1; j++) {
                    int gcd = gcd(Integer.parseInt(lines[i]), Integer.parseInt(lines[j]));
                    result += gcd;
                }
            }

            System.out.println(result);
        }

        br.close();
     }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
