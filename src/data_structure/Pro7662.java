package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Pro7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tc-- > 0) {
            int K = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else if (command.equals("D") && !map.isEmpty()) {
                    int key = 0;
                    if (number == 1) {
                        key = map.lastKey();
                    } else if (number == -1) {
                        key = map.firstKey();
                    }

                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }

            if (!map.isEmpty()) {
                int maxKey = map.lastKey();
                int minKey = map.firstKey();
                sb.append(maxKey).append(" ").append(minKey).append("\n");
            } else {
                sb.append("EMPTY").append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
