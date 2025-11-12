package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Pro13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]), L = Integer.parseInt(inputs[1]);

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String studentNumber = br.readLine();
            if (set.contains(studentNumber)) {
                set.remove(studentNumber);
            }
            set.add(studentNumber);
        }

        set.stream().limit(K).forEach(System.out::println);

        br.close();
    }
}
