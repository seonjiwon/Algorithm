package implementation;

import java.io.*;

public class Pro1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] years = br.readLine().split(" ");

        int targetE = Integer.parseInt(years[0]);
        int targetS = Integer.parseInt(years[1]);
        int targetM = Integer.parseInt(years[2]);

        int E = 1;
        int S = 1;
        int M = 1;

        int result = 1;

        while (true) {
            if (targetE == E && targetS == S && targetM == M) {
                System.out.println(result);
                break;
            }

            E = (E + 1) % 15 == 0 ? 15 : (E + 1) % 15;
            S = (S + 1) % 28 == 0 ? 28 : (S + 1) % 28;
            M = (M + 1) % 19 == 0 ? 19 : (M + 1) % 19;

            result++;
        }


        br.close();
    }
}
