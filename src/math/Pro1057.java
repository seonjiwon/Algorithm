package math;

import java.util.*;
import java.io.*;

public class Pro1057 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int round = Integer.parseInt(st.nextToken());
        float kim = Integer.parseInt(st.nextToken());
        float rim = Integer.parseInt(st.nextToken());

        int curRound = 1;


        while (true) {
            if (Math.round(kim / 2) == Math.round(rim / 2)) {
                break;
            }
            curRound++;

            kim = Math.round(kim / 2);
            rim = Math.round(rim / 2);
        }

        System.out.println(curRound);

        br.close();
    }
}
