package baekjoon.queue;

import java.io.*;
import java.util.*;

public class Pro4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boolean error = false;
            String line = br.readLine();
            if (line.length() == 1 && line.charAt(0) == '.') {
                break;
            }

            Deque<Character> deque = new ArrayDeque<>();
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    deque.offer(c);
                }

                if (c == ')' || c == ']'){
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }

                    if ((c == ')' && deque.peekLast() == '(') || (c == ']' && deque.peekLast() == '[')) {
                        deque.pollLast();
                    } else {
                        error = true;
                        break;
                    }
                }
            }

            if (!deque.isEmpty()) {
                error = true;
            }

            if (!error) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        br.close();
    }
}
