package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold2_2461_대표선수 {

    static int[][] students;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        students = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.sort(students[i]);
        }

        System.out.println(solution());

        br.close();
    }

    private static int solution() {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int maxValue = 0;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int ability = students[i][0];
            // 능력치, 학급번호, 학급에서의 인덱스
            pq.offer(new int[]{ability, i, 0});
            maxValue = Math.max(maxValue, ability);
        }

        while (pq.size() >= N) {
            int[] currentStudent = pq.poll();
            int ability = currentStudent[0];
            int classNumber = currentStudent[1];
            int studentIdx = currentStudent[2];

            result = Math.min(result, maxValue - ability);

            if (studentIdx < M - 1) {
                int newAbility = students[classNumber][studentIdx + 1];
                pq.offer(new int[]{newAbility, classNumber, studentIdx + 1});
                maxValue = Math.max(maxValue, newAbility);
            }
        }

        return result;
    }
}
