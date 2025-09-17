package greedy;

import java.util.*;
import java.io.*;

public class Pro15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        String[] cards = br.readLine().split(" ");

        PriorityQueue<Long> pq = new PriorityQueue<>();

        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);
        for (String card : cards) {
            pq.add(Long.parseLong(card));
        }

        for (int i = 0; i < m; i++) {
            Long firstNum = pq.poll();
            Long secondNum = pq.poll();

            pq.add(firstNum + secondNum);
            pq.add(firstNum + secondNum);
        }

        Long result = 0L;
        for (int i = 0; i < n; i++) {
            result += pq.poll();
        }

        System.out.println(result);


        br.close();
     }
}
