package greedy;

import java.util.*;
import java.io.*;

public class Pro2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] flowers = new int[N][4];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int[] flower = new int[4];
            for (int j = 0; j < 4; j++) {
                flower[j] = Integer.parseInt(inputs[j]);
            }
            flowers[i] = flower;
        }

        int solution = solution(N, flowers);
        System.out.println(solution);

        br.close();
    }

    private static int solution(int n, int[][] flowers) {
        // 시작 날짜 오름차순, 종료 날짜 내림차순
        Arrays.sort(flowers, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0]; // 시작 월
            }
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1]; // 시작 일
            }
            if (o1[2] != o2[2]) {
                return o2[2] - o1[2]; // 종료 월 (내림차순)
            }
            return o2[3] - o1[3]; // 종료 일 (내림차순)
        });

        int result = 0;

        int currentMonth = 3, currentDay = 1;
        int maxEndMonth = 0, maxEndDay = 0;

        int flowerIndex = 0;

        while (currentMonth < 12) {
            boolean found = false;

            // 현재 시점 이전에 피기 시작하는 꽃들 중 가장 늦게 지는 꽃을 찾습니다.
            while (flowerIndex < n) {
                int startMonth = flowers[flowerIndex][0];
                int startDay = flowers[flowerIndex][1];

                if (startMonth > currentMonth || (startMonth == currentMonth && startDay > currentDay)) {
                    break;
                }

                int endMonth = flowers[flowerIndex][2];
                int endDay = flowers[flowerIndex][3];

                // 가장 늦게 지는 꽃을 업데이트합니다.
                if (endMonth > maxEndMonth || (endMonth == maxEndMonth && endDay > maxEndDay)) {
                    maxEndMonth = endMonth;
                    maxEndDay = endDay;
                    found = true;
                }
                flowerIndex++;
            }

            // 더 이상 커버할 수 있는 꽃이 없는 경우
            if (!found) {
                return 0;
            }

            // 현재까지 찾은 가장 늦게 지는 꽃으로 현재 날짜를 업데이트합니다.
            currentMonth = maxEndMonth;
            currentDay = maxEndDay;
            result++;

            // 11월 30일 이후를 커버할 수 있는지 확인합니다.
            if (currentMonth > 11 || (currentMonth == 11 && currentDay > 30)) {
                return result;
            }
        }
        return 0;
    }
}
