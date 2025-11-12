package data_structure;

import java.io.*;
import java.util.*;

public class Pro10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        char previous = 0;
        int result = 0;

        for (char c : line.toCharArray()) {

            if (c == ')') {
                if (previous == '(') {
                    stack.pop();
                    result += stack.size();
                } else {
                    result += 1;
                    stack.pop();
                }
            } else {
                stack.push(c);
            }

            previous = c;
        }
        System.out.println(result);

        br.close();
    }
}
