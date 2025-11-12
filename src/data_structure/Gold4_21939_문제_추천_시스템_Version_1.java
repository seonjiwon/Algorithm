package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Gold4_21939_문제_추천_시스템_Version_1 {

    static class Problem {
        int p;
        int l;

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Problem> ts = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) {
                return o1.p - o2.p;
            }
            return o1.l - o2.l;
        });

        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            ts.add(problem);
            map.put(p, l);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    ts.add(new Problem(p, l));
                    map.put(p, l);
                    break;
                case "recommend":
                    int order = Integer.parseInt(st.nextToken());
                    if (order == 1) {
                        System.out.println(ts.last().p);
                    } else {
                        System.out.println(ts.first().p);
                    }
                    break;
                case "solved":
                    int sp = Integer.parseInt(st.nextToken());
                    int sl = map.get(sp);
                    ts.remove(new Problem(sp, sl));
                    break;
            }
        }

        br.close();
    }
}
