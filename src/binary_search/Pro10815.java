package binary_search;

import java.util.*;
import java.io.*;

public class Pro10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] sCards = new int[N];
        for (int i = 0; i < N; i++) {
            sCards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sCards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] targetCards = new int[M];
        for (int i = 0; i < M; i++) {
            targetCards[i] = Integer.parseInt(st.nextToken());
        }

        for (int targetCard : targetCards) {
            System.out.print(solution(targetCard, sCards) + " ");
        }

        br.close();
    }

    private static int solution(int targetCard, int[] sCards) {
        int start = 0;
        int end = sCards.length - 1;

        int flag = 0;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (targetCard == sCards[mid]) {
                flag = 1;
                break;
            }

            if (sCards[mid] > targetCard) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return flag;
    }
}
