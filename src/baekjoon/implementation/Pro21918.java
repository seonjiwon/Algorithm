package baekjoon.implementation;

import java.io.*;
import java.util.*;

public class Pro21918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        String[] array = br.readLine().split(" ");
        int[] state = Arrays.stream(array).mapToInt(Integer::parseInt)
                .toArray();

        while (M-- > 0) {
            String[] commands = br.readLine().split(" ");
            int cmd = Integer.parseInt(commands[0]);
            int l = Integer.parseInt(commands[1]);
            int r = Integer.parseInt(commands[2]);

            switch (cmd) {
                case 1:
                    state[l-1] = r;
                    break;
                case 2:
                    for (int i = l-1; i < r; i++) {
                        state[i] = state[i] == 0 ? 1 : 0;
                    }
                    break;
                case 3:
                    for (int i = l-1; i < r; i++) {
                        state[i] = 0;
                    }
                    break;
                case 4:
                    for (int i = l-1; i < r; i++) {
                        state[i] = 1;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int s : state) {
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
     }
}
