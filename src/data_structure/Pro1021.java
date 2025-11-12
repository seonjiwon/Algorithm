package data_structure;

import java.io.*;
import java.util.*;

public class Pro1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        String[] line = br.readLine().split(" ");
        int[] target = new int[M];
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i < M; i++) {
            int target_idx = queue.indexOf(target[i]);
            int half_idx;


            if(queue.size() % 2 == 0) {
                half_idx = queue.size() / 2 - 1;
            }
            else {
                half_idx = queue.size() / 2;
            }

            if (target_idx <= half_idx) {
                for (int j = 0; j < target_idx; j++) {
                    queue.offerLast(queue.poll());
                    cnt++;
                }
            } else {
                for (int j = 0; j < queue.size() - target_idx; j++) {
                    queue.offerFirst(queue.pollLast());
                    cnt++;
                }
            }
            queue.pollFirst();

        }

        System.out.println(cnt);
        br.close();
    }
}
