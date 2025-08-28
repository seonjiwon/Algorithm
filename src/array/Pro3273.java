package array;

import java.io.*;

public class Pro3273 {

    private static int Solution(int[] arr, int x){
        int result = 0;
        int[] array = new int[1_000_001];

        for (int i = 0; i < arr.length; i++) {
            array[arr[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            int target = x - arr[i];

            if (target > 0 && target <= 1_000_000 &&
                    target > arr[i] && array[target] > 0) {
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int x = Integer.parseInt(br.readLine());

        int solution = Solution(arr, x);
        System.out.println(solution);
        br.close();
     }
}
