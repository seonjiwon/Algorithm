package two_pointer;

import java.util.*;
import java.io.*;

public class Pro3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] students = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);


        long solution = solution(students, N);
        System.out.println(solution);

        br.close();
    }

    private static long solution(int[] arr, int n) {
        long result = 0;

        for (int i = 0; i < n - 2; i++) {
            int fixNumber = i; // 한 명을 고정
            // 나머지 2명 투 포인터
            int s = i + 1, e = n - 1;
            while (s < e) {
                int sum = arr[fixNumber] + arr[s] + arr[e];

                if (sum == 0) {
                    // 중복값 카운팅 필요

                    int sCount = 1;
                    while (s + 1 < e && arr[s] == arr[s + 1]) {
                        sCount++;
                        s++;
                    }

                    int eCount = 1;
                    while (e - 1 > s && arr[e] == arr[e - 1]) {
                        eCount++;
                        e--;
                    }

                    // 경우의 수 계산
                    if (arr[s] == arr[e]) {
                        // 같은 값들 중에서 2개를 선택하는 조합
                        // 예: [0, 0, 0]에서 2개 선택 -> 3C2 = 3
                        int totalCount = sCount + eCount;
                        result += (long) totalCount * (totalCount - 1) / 2;
                    } else {
                        // 서로 다른 값들의 조합
                        // 예: s에 2개, e에 3개 -> 2 * 3 = 6
                        result += (long) sCount * eCount;
                    }

                    s++;
                    e--;
                } else if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }

        return result;
    }
}
