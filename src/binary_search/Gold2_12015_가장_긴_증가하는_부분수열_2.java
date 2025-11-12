package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Gold2_12015_가장_긴_증가하는_부분수열_2 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());

        br.close();
    }

    private static int solution() {
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = arr[i];

//            int pos = binarySearch(lis, num);
            int pos = Collections.binarySearch(lis, num);

            if (pos < 0) {
                pos = -pos - 1;
            }

            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        return lis.size();
    }

    private static int binarySearch(List<Integer> lis, int target) {
        int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
