package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Pro1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> nameToNumber = new HashMap<>();
        Map<String, String> numberToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, String.valueOf(i));
            numberToName.put(String.valueOf(i), name);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (!input.matches("^[0-9]+$")) {
                System.out.println(nameToNumber.get(input));
            } else {
                System.out.println(numberToName.get(input));
            }

        }

        br.close();
    }
}
