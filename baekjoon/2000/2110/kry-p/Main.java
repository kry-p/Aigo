import java.util.*;
import java.io.*;

public class Main {
    private static int[] houses;
    private static int n, c;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        c = input[1];
        houses = new int[n];

        for (int i = 0; i < n; i++)
            houses[i] = Integer.parseInt(reader.readLine());

        Arrays.sort(houses); // 집의 좌표를 순서대로 정렬

        int left = 0, right = 1000000000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (attemptToInstall(mid)) {
                answer = mid;
                left = mid + 1; // 가능하다면 거리를 늘림
            } else right = mid - 1;
        }
        System.out.print(answer);
    }    

    // 해당 거리 차이를 두었을 때 설치할 수 있는지 판정
    private static boolean attemptToInstall(int distance) {
        int count = 1, lastPos = houses[0]; // 설치한 공유기 수, 공유기를 설치한 마지막 위치
        for (int i = 0; i < n; i++) {
            if (houses[i] - lastPos >= distance) {
                count += 1;
                lastPos = houses[i];
            }
        }
        return count >= c;
    }
}