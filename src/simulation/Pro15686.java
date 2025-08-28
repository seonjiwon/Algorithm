package simulation;

import java.util.*;
import java.io.*;

public class Pro15686 {
    static int N, M;
    static int[][] map;
    static List<int[]> houseLocation;
    static List<int[]> chickenLocation;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }

        chickenLocation = extractLocation(2);
        houseLocation = extractLocation(1);

        // 선택된 치킨집들의 인덱스를 저장할 배열
        int[] selected = new int[M];
        chickenCombination(0, 0, selected);

        System.out.println(minDistance);
        br.close();
    }

    private static void chickenCombination(int start, int depth, int[] selected) {
        if (depth == M) {
            // 현재 선택된 치킨집들로 치킨 거리 계산
            int distance = calculateChickenDistance(selected);
            minDistance = Math.min(minDistance, distance);
            return;
        }

        for (int i = start; i < chickenLocation.size(); i++) {
            selected[depth] = i;  // 치킨집 인덱스 저장
            chickenCombination(i + 1, depth + 1, selected);  // 핵심: i+1로 수정
        }
    }

    private static int calculateChickenDistance(int[] selected) {
        int totalDistance = 0;

        for (int[] house : houseLocation) {
            int minDist = Integer.MAX_VALUE;
            int houseR = house[0];
            int houseC = house[1];

            // 선택된 치킨집들과의 거리 중 최소값
            for (int idx : selected) {
                int[] chicken = chickenLocation.get(idx);
                int chickenR = chicken[0];
                int chickenC = chicken[1];
                int dist = Math.abs(chickenR - houseR) + Math.abs(chickenC - houseC);
                minDist = Math.min(minDist, dist);
            }

            totalDistance += minDist;
        }

        return totalDistance;
    }

    private static List<int[]> extractLocation(int target) {
        List<int[]> locations = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == target) {
                    locations.add(new int[]{i, j});
                }
            }
        }
        return locations;
    }
}