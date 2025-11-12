package implementation;

import java.io.*;

public class Pro4659 {
    public static boolean Solution(String password) {
        boolean result = true;


        // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
        String[] vowels = {"a", "e", "i", "o", "u"};
        boolean flag = false;
        for (String vowel : vowels) {
            if (password.contains(vowel)) {
                flag = true;
                break;
            }
        }

        // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
        char[] p = password.toCharArray();
        int cCnt = 0;
        int vCnt = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 'a' || p[i] == 'e' || p[i] == 'i' || p[i] == 'o' || p[i] == 'u') {
                vCnt++;
                cCnt = 0;
                if (vCnt >= 3) {
                    flag = false;
                    break;
                }
            } else {
                vCnt = 0;
                cCnt++;
                if (cCnt >= 3) {
                    flag = false;
                    break;
                }
            }
        }


        // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
        for (int i = 1; i < p.length; i++) {
            if (p[i] == p[i - 1] && !(p[i] == 'e' || p[i] == 'o')) {
                flag = false;
            }
        }

        result = flag;

        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;

        while (!(password = br.readLine()).equals("end")){
            if(Solution(password)){
                System.out.println("<" + password + "> is acceptable.");
            } else {
                System.out.println("<" + password + "> is not acceptable.");
            }
        }

        br.close();
     }
}
