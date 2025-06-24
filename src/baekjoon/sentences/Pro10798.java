package baekjoon.sentences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pro10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 5;
        ArrayList<String> list = new ArrayList<>();

        int maxCount = 0;
        for (int i = 0; i < tc; i++) {
            String line = br.readLine();
            maxCount = Math.max(maxCount, line.length());
            list.add(line);
        }


        for (int i = 0; i < maxCount; i++) {
            for (int j = 0; j < tc; j++) {
                if (list.get(j).length() > i) {
                    System.out.print(list.get(j).charAt(i));
                }
            }
        }

        br.close();
     }
}
