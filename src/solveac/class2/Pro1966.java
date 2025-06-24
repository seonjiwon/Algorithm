package solveac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pro1966 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            String[] priorities = br.readLine().split(" ");
            Queue<int[]> queue = new LinkedList<>(); // [중요도, 인덱스]
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(priorities[i]);
                queue.offer(new int[]{priority, i});
                maxHeap.offer(priority);
            }

            int printCount = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                // 제일 앞에 있는 값의 우선순위가 가장 높으면 꺼냄
                if (current[0] == maxHeap.peek()) {
                    printCount++;
                    maxHeap.poll();
                    if (current[1] == M) {
                        System.out.println(printCount);
                        break;
                    }
                } else {
                    // 뒤로 보내기
                    queue.offer(current);
                }
            }

        }

        br.close();
    }
}
