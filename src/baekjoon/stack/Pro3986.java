package baekjoon.stack;

import java.io.*;
import java.util.*;

public class Pro3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (N-- > 0) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            for (char c : line.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                Character peek = stack.peek();
                if (peek == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            cnt += stack.isEmpty() ? 1 : 0;
        }

        System.out.println(cnt);
        br.close();
    }
}
