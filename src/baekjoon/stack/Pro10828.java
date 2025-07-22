package baekjoon.stack;

import java.io.*;
import java.util.*;

public class Pro10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        while (N-- > 0) {
            String[] split = br.readLine().split(" ");
            switch (split[0]) {
                case "push":
                    stack.push(split[1]);
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }

        }

        br.close();
     }
}
