package data_structure;

import java.io.*;

public class Pro10807 {
    
    private static int Solution(int[] arr, int v){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                result++;
            }
        }

        return result;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int v = Integer.parseInt(br.readLine());
        int solution = Solution(arr, v);
        System.out.println(solution);


        br.close();
     }
}
