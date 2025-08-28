package stack;

import java.io.*;
import java.util.*;

public class Pro1406 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : str.toCharArray()){
            leftStack.push(c);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L':
                    if (!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    char ch = cmd.charAt(2);
                    leftStack.push(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            sb.append(leftStack.pop());
        }
        sb.reverse();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);

        br.close();
     }
}
