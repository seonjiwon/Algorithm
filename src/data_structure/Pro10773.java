package data_structure;

import java.io.*;
import java.util.*;

public class Pro10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }

        Integer result = stack.stream()
                .reduce(0, Integer::sum);

        System.out.println(result);

        br.close();
    }
}
