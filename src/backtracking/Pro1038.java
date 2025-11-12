package backtracking;

import java.util.*;
import java.io.*;

public class Pro1038 {
    private static int N;
    private static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>(List.of(0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));

        for (int i = 1; i <= 9; i++) {
            solution(i);
        }

        Collections.sort(list);
        Long result = N >= list.size() ? -1 : list.get(N);
        System.out.println(result);
        br.close();
    }

    private static void solution(long number) {
        if (number % 10 == 0) {
            return;
        }

        for (int i = 1; i <= number % 10; i++) {
            number = (10 * number) + (number % 10 - i);
            list.add(number);
            solution(number);
            number = number / 10;
        }
    }
}
