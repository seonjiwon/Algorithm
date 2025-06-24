package solveac.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pro1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Object> result = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        int[] stack = new int[N];

        int idx = 0;
        int start = 0;

        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value > start) {
                for (int i = start + 1; i <= value; i++) {
                    stack[idx] = i;
                    idx++;
                    result.add("+");
                }
                start = value;
            } else if (stack[idx-1] != value){
                System.out.println("NO");
                return;
            }

            idx--;
            result.add("-");
        }

        result.stream()
                .forEach(System.out::println);
        br.close();
    }
}
