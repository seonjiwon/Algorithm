package baekjoon.queue;

import java.io.*;
import java.util.*;

public class Pro5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Deque<Integer> queue = new ArrayDeque<>();

            if (n > 0) {
                String numbers = str.substring(1, str.length() - 1);
                String[] numArray = numbers.split(",");
                for (String num : numArray) {
                    queue.offer(Integer.parseInt(num));
                }
            }

            // true: 순방향, false: 역방향
            boolean flag = true;
            boolean error = false;
            for (int i = 0; i < func.length(); i++) {
                char f = func.charAt(i);
                if (f == 'R') {
                    flag = !flag;
                    continue;
                }

                if (queue.isEmpty()) {
                    error = true;
                    break;
                }


                if (flag) {
                    queue.poll();
                } else {
                    queue.pollLast();
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");

                if (!queue.isEmpty()) {
                    if (flag) {
                        while (queue.size() > 1) {
                            sb.append(queue.pollFirst()).append(",");
                        }
                        sb.append(queue.pollFirst());
                    } else {
                        while (queue.size() > 1) {
                            sb.append(queue.pollLast()).append(",");
                        }
                        sb.append(queue.pollLast());
                    }
                }

                sb.append("]\n");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
