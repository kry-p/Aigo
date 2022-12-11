import java.io.*;
import java.util.*;

public class Main {
    private static long[] buildings, max;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        max = new long[n];
        buildings = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
       
        boolean isVisible;
        // i : 시작점, j : 보고자 하는 건물, k : 중간 지점
        for (int i = 0; i < n - 1; i++) {
            // 이전 건물을 바라볼 필요가 없음 (1 - 3을 보나 3 - 1을 보나 같은 경우)
            for (int j = i + 1; j < n; j++) {
                isVisible = true;
                // i ~ j 구간 내에 장애물이 없는지 체크
                for (int k = i + 1; k < j; k++) {
                    // i - j의 기울기보다 i - k의 기울기가 크면 가려져서 볼 수 없음
                    if (i * buildings[k] + j * buildings[i] + k * buildings[j] - (i * buildings[j] + j * buildings[k] + k * buildings[i]) <= 0) {
                        isVisible = false;
                        break;
                    }
                }
                // 볼 수 있으면 양 끝점에 대해 볼 수 있는 건물 수 + 1
                if (isVisible) {
                    max[i] += 1;
                    max[j] += 1;
                }
            }
        }
        long maxValue = 0;
        for (long i : max)
            maxValue = Math.max(maxValue, i);

        System.out.print(maxValue);
    }
}