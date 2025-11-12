package data_structure;

import java.io.*;
import java.util.*;

public class Pro5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            Stack<String> leftStack = new Stack<>();
            Stack<String> rightStack = new Stack<>();

            String[] cmd = br.readLine().split("");
            for (String s : cmd) {
                switch (s) {
                    case "-":
                        if (!leftStack.isEmpty()) {
                            leftStack.pop();
                        }
                        break;
                    case "<":
                        if (!leftStack.isEmpty()) {
                            rightStack.push(leftStack.pop());
                        }
                        break;
                    case ">":
                        if (!rightStack.isEmpty()) {
                            leftStack.push(rightStack.pop());
                        }
                        break;
                    default:
                        leftStack.push(s);

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
        }



        br.close();
    }
}
