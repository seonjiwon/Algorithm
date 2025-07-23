package baekjoon.queue;

import java.io.*;
import java.util.*;

public class Pro2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N+1; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            queue.poll();
            if (queue.size() == 1) {
                break;
            }
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
        br.close();
    }
}
