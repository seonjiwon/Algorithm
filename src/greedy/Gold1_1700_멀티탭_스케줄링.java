package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold1_1700_멀티탭_스케줄링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> multiTap = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < K; i++) {
            int device = order[i];

            if (multiTap.contains(device)) {
                continue;
            }

            if (multiTap.size() < N) {
                multiTap.add(device);
                continue;
            }

            int farthest = -1;
            int removeIdx = -1;

            for (int j = 0; j < multiTap.size(); j++) {
                int plugged = multiTap.get(j);
                int nextUse = findNextUse(order, i + 1, plugged);

                if (nextUse == -1) {
                    removeIdx = j;
                    break;
                }

                if (nextUse > farthest) {
                    farthest = nextUse;
                    removeIdx = j;
                }
            }

            multiTap.remove(removeIdx);
            multiTap.add(device);
            count++;
        }

        System.out.println(count);
        br.close();
    }

    private static int findNextUse(int[] order, int i, int plugged) {
        for (int j = i; j < order.length; j++) {
            if (order[j] == plugged) {
                return j;
            }
        }
        return -1;
    }
}
