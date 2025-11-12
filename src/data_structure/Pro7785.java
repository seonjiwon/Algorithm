package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Pro7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] token = br.readLine().split(" ");
            String name = token[0];
            String state = token[1];

            map.put(name, state);
        }

        List<String> keyList = map.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (String key : keyList) {
            if (map.get(key).equals("enter")) {
                System.out.println(key);
            }
        }


        br.close();
    }
}
