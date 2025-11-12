package implementation;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Pro1764 {
    private static List<String> Solution(List<String> listA, List<String> listB){
        List<String> mergedList = new ArrayList<>();
        mergedList.addAll(listA);
        mergedList.addAll(listB);

        Map<String, Integer> map = mergedList.stream()
                .collect(Collectors.toMap(
                        name -> name,
                        name -> 1,
                        (oldVal, newVal) -> oldVal + newVal
                ));
//        System.out.println("map = " + map);


        return map.keySet().stream()
                .filter(n -> map.get(n) >= 2)
                .sorted()
                .collect(Collectors.toList());
    }

    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        List<String> neverHeardPeople = new ArrayList<>();
        List<String> neverSawedPeople = new ArrayList<>();

        while (N-- > 0) {
            neverHeardPeople.add(br.readLine());
        }

        while (M-- > 0) {
            neverSawedPeople.add(br.readLine());
        }

        List<String> result = Solution(neverHeardPeople, neverSawedPeople);


        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

        br.close();
     }
}
