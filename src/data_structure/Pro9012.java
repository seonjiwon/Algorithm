package data_structure;

import java.io.*;
import java.util.*;

public class Pro9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            for (char c : line.toCharArray()) {
                if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }

                    Character peek = stack.peek();
                    if (peek == '(') {
                        stack.pop();
                    } else {
                        break;
                    }
                } else {
                    stack.push(c);
                }

            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
        br.close();
    }
}
