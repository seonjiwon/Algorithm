package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//4 4
//1 100
//2 200
//13 300
//10 500
//10
//10
//10
//14
// answer: 1100
public class Pro1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i][0] = weight;
            jewels[i][1] = value;
        }
        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long result = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int j = 0;
        for (int i = 0; i < K; i++) {

            while (j < N && jewels[j][0] <= bags[i]) {
                pq.offer(jewels[j][1]);
                j++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);

        br.close();
    }
}
