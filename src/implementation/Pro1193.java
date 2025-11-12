package implementation;

import java.io.*;

public class Pro1193 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sumCount = 0;
        int groupCount = 1;

        while (true) {
            sumCount += groupCount;
            if (sumCount >= N) {
                break;
            }
            groupCount++;
        }


        int orderInGroup = N - (sumCount - groupCount);

        int child;
        int parent;

        if (groupCount % 2 == 0) {
            child = orderInGroup;
            parent = groupCount - orderInGroup + 1;
        } else {
            parent = orderInGroup;
            child = groupCount - orderInGroup + 1;
        }

        System.out.println(child + "/" + parent);

        br.close();
    }
}
