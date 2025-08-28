package sentences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        String number = br.readLine();

        for (int i = 0; i < N; i++) {
            result += number.charAt(i) - '0';
        }

        System.out.println(result);
        br.close();
     }
}
