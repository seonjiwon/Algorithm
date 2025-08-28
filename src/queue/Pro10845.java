package queue;

import java.io.*;
import java.util.*;

public class Pro10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<String> queue = new ArrayDeque<>();

        while (N-- > 0) {
            String[] split = br.readLine().split(" ");
            switch (split[0]) {
                case "push":
                    queue.offer(split[1]);
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
                    break;
            }

        }

        br.close();
    }
}
