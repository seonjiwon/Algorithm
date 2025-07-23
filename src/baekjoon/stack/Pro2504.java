package baekjoon.stack;

import java.io.*;
import java.util.*;

public class Pro2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Stack<Character> stack = new Stack<>();

        boolean error = false;
        int result = 0;
        int temp = 1;
        char previous = 0;

        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                temp *= (c == '(' ? 2 : 3);
            } else {
                if (stack.isEmpty()){
                    error = true;
                    break;
                }

                char top = stack.peek();

                if (c == ')') {
                    if (top != '(') {
                        error = true;
                        break;
                    }
                    if (previous == '(') {
                        result += temp;
                    }
                    temp /= 2;
                    stack.pop();
                } else if (c == ']') {
                    if (top != '[') {
                        error = true;
                        break;
                    }
                    if (previous == '[') {
                        result += temp;
                    }
                    temp /= 3;
                    stack.pop();
                }
            }

            previous = c;
        }

        if (!stack.isEmpty()) {
            error = true;
        }


        System.out.println(error ? 0 : result);

        br.close();
    }
}
