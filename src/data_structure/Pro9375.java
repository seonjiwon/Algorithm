package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Pro9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] tokens = br.readLine().split(" ");
                String name = tokens[0];
                String type = tokens[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            Collection<Integer> values = map.values();
            int result = 1;
            for (Integer value : values) {
                result *= (value + 1);
            }

            System.out.println(result - 1);
        }

        br.close();
    }
}
