package greedy;

import java.util.*;
import java.io.*;

public class Pro1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] meetingTime = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(meetingTime[0]);
            meetings[i][1] = Integer.parseInt(meetingTime[1]);
        }

        // 회의 종료 시간을 기준으로 오름차순 정렬.
        // 종료 시간이 같을 경우 시작 시간을 기준으로 오름차순 정렬.
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < N; i++) {
            // 현재 회의의 시작 시간이 이전에 선택한 회의의 종료 시간보다 같거나 늦으면 선택 가능
            if (meetings[i][0] >= lastEndTime) {
                lastEndTime = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
