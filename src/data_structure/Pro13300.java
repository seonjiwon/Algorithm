package data_structure;

import java.io.*;

public class Pro13300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[][] studentCount = new int[2][6];

        // 성별 학년
        // 여학생 0 남학생 1
        while (N-- > 0) {
            String[] split1 = br.readLine().split(" ");
            int S = Integer.parseInt(split1[0]);
            int Y = Integer.parseInt(split1[1]);

            studentCount[S][Y-1]++;
        }

        int result = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                result += (int) Math.ceil(((double) studentCount[i][j] / K));
            }
        }

        System.out.println(result);


        br.close();
     }
}
