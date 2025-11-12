package implementation;

import java.io.*;
import java.util.*;

public class Pro1292 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int startIdx = Integer.parseInt(st.nextToken());
        int endIdx = Integer.parseInt(st.nextToken());

        int idx = 1;
        int result = 0;
        for (int i = 1; i < 50; i++) {
            for (int j = 0; j < i; j++) {
                if (idx >= startIdx && idx <= endIdx) {
                    result += i;
                }
                idx++;
            }
        }

        System.out.println(result);
        br.close();
    }
}
