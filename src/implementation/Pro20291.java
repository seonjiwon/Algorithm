package implementation;

import java.io.*;
import java.util.*;

public class Pro20291 {
    private static Map<String, Integer> Solution(List<String> extendList){
        Map<String, Integer> map = new TreeMap<>();

        for (String extend : extendList) {
            map.put(extend, map.getOrDefault(extend, 0) + 1);
        }

        return map;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while (N-- > 0) {
            String fileName = br.readLine();
            String extend = extraceExtend(fileName);
            list.add(extend);
        }

        Map<String, Integer> solution = Solution(list);

        for (String key : solution.keySet()) {
            System.out.println(key + " " + solution.get(key));
        }

        br.close();
     }

    private static String extraceExtend(String fileName) {
        int index = fileName.indexOf('.');
        String extend = fileName.substring(index+1, fileName.length());
        return extend;
    }
}
