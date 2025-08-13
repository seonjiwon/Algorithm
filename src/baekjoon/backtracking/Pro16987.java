package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class Pro16987 {

    static int N;

    static List<Integer> durability;
    static List<Integer> weight;
    static int maxBroken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        durability = new ArrayList<>();
        weight = new ArrayList<>();
        maxBroken = 0;

        for (int i = 0; i < N; i++) {
            String[] eggInfo = br.readLine().split(" ");
            durability.add(Integer.parseInt(eggInfo[0]));
            weight.add(Integer.parseInt(eggInfo[1]));
        }

        backtracking(0);

        System.out.println(maxBroken);

        br.close();
    }


    private static void backtracking(int currentEgg) {

        if (currentEgg == N) {
            // 현재 깨진 계란 수 계산
            int brokenCount = 0;
            for (int i = 0; i < N; i++) {
                if (durability.get(i) <= 0) {
                    brokenCount++;
                }
            }
            maxBroken = Math.max(maxBroken, brokenCount);
            return;
        }

        // 현재 계란이 이미 깨진 경우 다음 계란으로
        if (durability.get(currentEgg) <= 0) {
            backtracking(currentEgg + 1);
            return;
        }

        // 칠 수 있는 계란이 있는지 확인
        boolean canHit = false;
        for (int i = 0; i < N; i++) {
            if (i != currentEgg && durability.get(i) > 0) {
                canHit = true;
                break;
            }
        }

        // 칠 수 있는 계란이 없으면 다음 계란으로
        if (!canHit) {
            backtracking(currentEgg + 1);
            return;
        }

        // 모든 다른 계란을 쳐보기
        for (int i = 0; i < N; i++) {
            // 자기 자신이 아니고 깨지지 않은 계란만 칠 수 있음
            if (i != currentEgg && durability.get(i) > 0) {
                // 계란끼리 충돌: 서로의 내구도가 상대방 무게만큼 감소
                int originalDurabilityA = durability.get(currentEgg);
                int originalDurabilityB = durability.get(i);

                durability.set(currentEgg, originalDurabilityA - weight.get(i));
                durability.set(i, originalDurabilityB - weight.get(currentEgg));

                // 다음 계란으로 재귀 호출
                backtracking(currentEgg + 1);

                // 백트래킹: 원래 상태로 복구
                durability.set(currentEgg, originalDurabilityA);
                durability.set(i, originalDurabilityB);
            }
        }
    }
}