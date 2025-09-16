package greedy;

import java.util.*;
import java.io.*;

public class Pro11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] lessons = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] lesson = br.readLine().split(" ");
            lessons[i][0] = Integer.parseInt(lesson[0]);
            lessons[i][1] = Integer.parseInt(lesson[1]);
        }

        // 수업 종료 시간을 기준으로 오름 차순
        // 종료 시간이 같다면 시작 시간을 기준으로 오름차순
        Arrays.sort(lessons, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // 끝나는 시간을 기준으로 우선순위 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(lessons[0][1]);

        for (int i = 1; i < N; i++) {
            // 현재 강의의 시작 시간이 queue 의 끝나는 시간 보다 늦으면
            if (lessons[i][0] >= queue.peek()) {
                // 강의실 재사용을 위해 제거
                queue.poll();
            }
            // 강의 추가
            queue.add(lessons[i][1]);
        }

        System.out.println(queue.size());

        br.close();
     }
}
