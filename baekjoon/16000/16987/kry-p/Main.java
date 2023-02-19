import java.util.*;
import java.io.*;

public class Main {
    private static int[] durability, weight;
    private static int max, n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        durability = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            durability[i] = Integer.parseInt(input[0]);
            weight[i] = Integer.parseInt(input[1]);
        }
        dfs(0, 0);
        System.out.print(max);
    }

    private static void dfs(int currentIndex, int count) {
        int currentCount = count; // 현재 카운트의 백업
        // 종료 조건
        if (currentIndex == n) {
            max = Math.max(max, count);
            return;
        }
        // 더 이상 깨질 계란이 없거나 현재 인덱스의 계란이 이미 깨진 상태면 다음으로
        if (durability[currentIndex] <= 0 || count == n - 1) {
            dfs(currentIndex + 1, count);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (durability[i] <= 0) continue;
            if (i == currentIndex) continue;
            
            durability[currentIndex] -= weight[i];
            durability[i] -= weight[currentIndex]; 

            if (durability[currentIndex] <= 0) count += 1;
            if (durability[i] <= 0) count += 1;

            dfs(currentIndex + 1, count);
            
            durability[currentIndex] += weight[i];
            durability[i] += weight[currentIndex];

            count = currentCount;
        }
    }
}