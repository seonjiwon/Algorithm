package implementation;

import java.util.*;
import java.io.*;

public class Pro18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] compressed = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];

            // 중복 제거
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                set.add(arr[j]);
            }

            // Set을 List로 변환 후 정렬
            List<Integer> sorted = new ArrayList<>(set);
            Collections.sort(sorted);

            // 이진 탐색으로 좌표 압축
            for (int j = 0; j < N; j++) {
                compressed[i][j] = Collections.binarySearch(sorted, arr[j]);
            }
        }

        // 균등한 우주 쌍 카운팅
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(compressed[i], compressed[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}