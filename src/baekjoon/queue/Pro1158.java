package baekjoon.queue;

import java.io.*;
import java.util.*;

public class Pro1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (queue.size() != 1) {
            for (int i = 0; i < K-1; i++) {
                queue.offer(queue.poll());
            }

            sb.append(queue.poll() + ", ");
        }

        sb.append(queue.poll());

        sb.append(">");
        System.out.println(sb);


        br.close();
     }
}
