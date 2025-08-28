package greedy;

import java.util.*;
import java.io.*;

public class Pro2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            lines[i][0] = Integer.parseInt(line[0]);
            lines[i][1] = Integer.parseInt(line[1]);
        }

        int solution = solution(N, lines);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int n, int[][] lines) {
        Arrays.sort(lines, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int result = 0;
        int currStart = lines[0][0];
        int currEnd = lines[0][1];

        for (int i = 1; i < n; i++) {
            int nextStart = lines[i][0];
            int nextEnd = lines[i][1];

            if (nextStart <= currEnd) {
                currEnd = Math.max(currEnd, nextEnd);
            } else {
                result += currEnd - currStart;
                currStart = nextStart;
                currEnd = nextEnd;
            }
        }

        result += currEnd - currStart;

        return result;
    }
}
