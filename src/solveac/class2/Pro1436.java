package solveac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro1436 {

    private static final String SIGNATURE = "666";

    public static int Solution(int number) {
        int result = 0;
        int i = 0;
        int cnt = 0;

        while (true) {
            if (String.valueOf(i).contains(SIGNATURE)) {
                cnt++;
                if (cnt == number) {
                    result = i;
                    break;
                }
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        System.out.println(Solution(number));
        br.close();
    }
}
