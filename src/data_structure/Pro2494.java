package data_structure;

import java.io.*;
import java.util.*;

public class Pro2494 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");

        Stack<int[]> stack = new Stack<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(split[i]);

            while (!stack.isEmpty() && stack.peek()[0] < height) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1] + 1;
            } else {
                result[i] = 0;
            }

            stack.push(new int[]{height, i});
        }


        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i + " ");
        }
        System.out.println(sb);

        br.close();
    }
}
