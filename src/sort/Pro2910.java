package sort;

import java.io.*;
import java.util.*;

public class Pro2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);

        LinkedHashMap<Integer, Integer> frequencyMap = new LinkedHashMap<>();
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(line[i]);
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int number = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(number).append(" ");
            }
        }
        System.out.println(sb.toString().trim());

        br.close();
     }
}
