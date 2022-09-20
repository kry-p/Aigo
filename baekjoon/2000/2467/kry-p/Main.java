import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        int left = 0; 
        int right = size - 1;

        int[] answer = { array[left], array[right] };
        int sum = Math.abs(array[left] + array[right]);

        while (left < right) {
            int currentSum = array[left] + array[right];

            if (Math.abs(currentSum) < sum) {
                sum = Math.abs(currentSum);
                answer[0] = array[left];
                answer[1] = array[right];
            }

            if (currentSum < 0) left += 1;
            else right -= 1;
        }
        
        System.out.println(answer[0] + " " + answer[1]);
    }
}
