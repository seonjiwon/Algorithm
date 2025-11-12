package implementation;

import java.io.*;
import java.util.*;

public class Pro1764HashSet {
    private static List<String> Solution(HashSet<String> listA, HashSet<String> listB){

        List<String> result = new ArrayList<>();
        for (String s : listA) {
            if(listB.contains(s)){
                result.add(s);
            }
        }
        Collections.sort(result);

        return result;
    }

    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        HashSet<String> neverHeardPeople = new HashSet<>();
        HashSet<String> neverSawedPeople = new HashSet<>();

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
