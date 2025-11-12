package backtracking;

import java.util.*;
import java.io.*;

public class Pro1759 {

    static int L, C;
    static char[] chars;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(chars);

        combination(0, 0, new char[L]);

        for (String password : result) {
            System.out.println(password);
        }

        br.close();
    }

    private static void combination(int start, int depth, char[] selected) {
        if (depth == L) {
            if (isValid(selected)) {
                result.add(new String(selected));
            }
            return;
        }

        for (int i = start; i < C; i++) {
            selected[depth] = chars[i];
            combination(i + 1, depth + 1, selected);
        }
    }

    private static boolean isValid(char[] password) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : password) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }
        return vowelCount >= 1 && consonantCount >= 2;
    }
}