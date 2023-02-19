import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // int[] sum = new int[n + 1];
        int max = 0;
        int sum = 0;
        int startIndex = 0, endIndex = 0;

        while (endIndex < n) {
            if (sum + array[endIndex] <= m) {
                sum += array[endIndex];
                max = Math.max(max, sum);
                endIndex += 1;
            } else {
                sum -= array[startIndex];
                startIndex += 1;
            }
            if (startIndex > endIndex) {
                sum += array[endIndex];
                endIndex += 1;
            }
        }

        // for (int i = 1; i < n + 1; i++) 
        //     sum[i] = sum[i - 1] + array[i - 1];
            
        // for (int i = 0; i < n; i++) {
        //     if (array[i] > m) continue; // 해당 위치의 구멍 크기가 부피보다 크면 넘김
        //     for (int j = i; j < n; j++) {
        //         int currentSum = sum[j + 1] - sum[i];
        //         if (currentSum > m) break; // 양수의 합이므로 넘으면 바로 다음으로 넘기기
        //         max = Math.max(max, currentSum);
        //     }
        // }
        
        System.out.print(max);
    }    
}
