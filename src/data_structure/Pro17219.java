package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Pro17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            map.put(tokens[0], tokens[1]);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(map.get(br.readLine()));
        }

        br.close();
    }
}
